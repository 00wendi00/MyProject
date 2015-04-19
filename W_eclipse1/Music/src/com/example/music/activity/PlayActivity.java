package com.example.music.activity;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.music.R;
import com.example.music.modle.AppConstant;
import com.example.music.modle.CircleImageView;
import com.example.music.modle.LrcRow;
import com.example.music.modle.LrcView;
import com.example.music.modle.LrcView.OnLrcClickListener;
import com.example.music.modle.Mp3Info;
import com.example.music.utils.DefaultLrcParser;
import com.example.music.utils.FastBlur;
import com.example.music.utils.FileUtil;
import com.example.music.utils.HttpCallbackListener;
import com.example.music.utils.HttpUtil;
import com.example.music.utils.MediaUtils;

public class PlayActivity extends Activity {
	
	private SeekBar mSeekBar;		//进度条
	private RelativeLayout playActivityLayout;		//播放页主界面
	private RelativeLayout albumLayout;
	private Bitmap bm;
	private ImageView backBtn;		//返回按钮
	private TextView title;			//歌曲名称
	private CircleImageView album;		//专辑圆形封面
	private ImageView loop;			//循环模式按钮
	private ImageView nextBtn;		//下一首
	private ImageView playBtn;		//播放（播放、暂停）
	private ImageView preBtn;		//上一首
	private ImageView lanmu;		//栏目按钮
	private TextView startTime;		//歌曲当前的时间
	private TextView endTime;		//歌曲结束的时间
	private float degree;
	private String artist;
	boolean clickFlag = true;
	boolean repeatCurrentFlag = false;
	boolean shuffleFlag = false;
	boolean repeatAllFlag = true;
	
	private String titleText;	//歌曲名称
    private String url;         //歌曲路径  
    private int listPosition;   //播放歌曲在mp3Infos的位置  
    private int currentTime;    //当前歌曲播放时间  
    private long duration;       //歌曲长度  
    private int flag;           //播放标识  
    private int repeatState;  
    private final int isCurrentRepeat = 1; // 单曲循环  
    private final int isAllRepeat = 2;      // 全部循环  
    private boolean isFirstTime = true;
    private boolean isPlaying;              // 正在播放  
    private boolean isPause;                // 暂停  
    private boolean isNoneShuffle;           // 顺序播放  
    private boolean isShuffle;          // 随机播放  
    private PlayerReceiver playerReceiver;
	private SharedPreferences pref;
	private SharedPreferences.Editor editor;
	private PlayThread playThread;
	private int fileSize = 0;		//文件一共的大小
	private LrcView mLrcView;
	private Animation mShowAction;
	private Animation mHiddenAction;
	private Boolean HttpResult;
	private  File file ;
	private boolean tmpShuffleFlag = false;
	private boolean tmpRepeatAllFlag = true;
	private boolean tmpRepeatCurrentFlag = false; 
	private Drawable loopBg;
	
    private List<Mp3Info> mp3Infos;  
    public static final String UPDATE_ACTION = "com.music.action.UPDATE_ACTION";  //更新动作  
    public static final String CTL_ACTION = "com.music.action.CTL_ACTION";        //控制动作  
    public static final String MUSIC_CURRENT = "com.music.action.MUSIC_CURRENT";  //音乐当前时间改变动作  
    public static final String MUSIC_DURATION = "com.music.action.MUSIC_DURATION";//音乐播放长度改变动作  
    public static final String MUSIC_PLAYING = "com.music.action.MUSIC_PLAYING";  //音乐正在播放动作  
    public static final String REPEAT_ACTION = "com.music.action.REPEAT_ACTION";  //音乐重复播放动作  
    public static final String SHUFFLE_ACTION = "com.music.action.SHUFFLE_ACTION";//音乐随机播放动作  
      

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.play_activity_layout);
		
		pref = getSharedPreferences("data", MODE_PRIVATE);
		editor = pref.edit();
		finViewById();
		setViewOnclickListener();
		playThread = new PlayThread();
		mp3Infos = MediaUtils.getMp3Infos(PlayActivity.this); 
		setAnimate();
		playerReceiver = new PlayerReceiver();  
        IntentFilter filter = new IntentFilter();  
        filter.addAction(UPDATE_ACTION);  
        filter.addAction(MUSIC_CURRENT);  
        filter.addAction(MUSIC_DURATION);
        registerReceiver(playerReceiver, filter); 
        getBunder();

        File file = new File(getPath(titleText));
	    if (!file.exists()) {
	        queryServer(titleText,artist);
	   		new Thread(){
	   			@Override
	   			public void run() {
	   				downloadFile(pref.getString(titleText, ""));
	   				super.run();
	   			}
	   		}.start();
	
	    }
	}
	
	/**
	 * 在onResume中初始化和接收Activity数据
	 */
	@Override
	protected void onResume() {
		super.onResume();
		initView();
		shuffleFlag = tmpShuffleFlag;
		repeatAllFlag = tmpRepeatAllFlag;
		repeatCurrentFlag = tmpRepeatCurrentFlag;
		if (loopBg !=null){
			loop.setBackground(loopBg);
		}
		
	}
	
	public void getBunder(){
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		titleText = bundle.getString("title");
		artist = bundle.getString("artist");
		url = bundle.getString("url");
		listPosition = bundle.getInt("listPosition");
		flag = bundle.getInt("MSG");
		isPlaying = bundle.getBoolean("isPlaying");
		isPause = bundle.getBoolean("isPause");
		
		if (isPlaying){
			playBtn.setBackgroundResource(R.drawable.img_lockscreen_pause_normal);
			 playThread.start();
		}else {
			playBtn.setBackgroundResource(R.drawable.img_lockscreen_play_normal);
		}
		editor.putBoolean("isPlaying", isPlaying);
		editor.putBoolean("isPause", isPause);
		editor.commit();
		duration = bundle.getLong("duration");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		tmpShuffleFlag=shuffleFlag;
		tmpRepeatAllFlag=repeatAllFlag;
		tmpRepeatCurrentFlag=repeatCurrentFlag;
		loopBg = loop.getBackground();
	}
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(playerReceiver);
	}
	
	public void initView(){
		title.setText(titleText);
		mSeekBar.setProgress(currentTime);
		mSeekBar.setMax((int) duration);
		endTime.setText(MediaUtils.formatTime(duration));
		Mp3Info mp3Info = mp3Infos.get(listPosition);
		showArtwork(mp3Info);
	}
	
	/**
	 * 显示专辑封面
	 */
	private void showArtwork(Mp3Info mp3Info) {
		Bitmap bm = MediaUtils.getArtwork(this, mp3Info.getId(), mp3Info.getAlbumId(), true, false);
		if(bm != null) {
			album.setImageBitmap(bm);	//显示专辑封面图片
		} else {
			bm = MediaUtils.getDefaultArtwork(this, false);
			album.setImageBitmap(bm);	//显示专辑封面图片
		}
		Bitmap bgBitmap =bm.copy(Bitmap.Config.ARGB_8888, true);
		Drawable drawable = new BitmapDrawable(FastBlur.doBlur(bgBitmap, 15, true)); 
		playActivityLayout.setBackgroundDrawable(drawable);
		
	}
	
	
	private void finViewById(){
		playActivityLayout = (RelativeLayout) findViewById(R.id.play_activity_layout);
		mSeekBar = (SeekBar) findViewById(R.id.seekbar);
		backBtn = (ImageView) findViewById(R.id.back_btn);
		title = (TextView) findViewById(R.id.play_title);
		album =  (CircleImageView)findViewById(R.id.album_play);
		startTime = (TextView) findViewById(R.id.start_time);
		endTime = (TextView) findViewById(R.id.end_time);
		loop = (ImageView) findViewById(R.id.loop);
		preBtn = (ImageView) findViewById(R.id.play_pre_btn);
		nextBtn = (ImageView) findViewById(R.id.play_next_btn);
		playBtn = (ImageView) findViewById(R.id.play_play_btn);
		lanmu = (ImageView) findViewById(R.id.lanmu);
		albumLayout = (RelativeLayout) findViewById(R.id.alubnlayout);
		mLrcView = (LrcView) findViewById(R.id.lrcView);
	}
	
	private void setViewOnclickListener(){
		ViewOnClickListener viewOnClickListener = new ViewOnClickListener();
		SeekBarChangeListener seekBarChangeListener = new SeekBarChangeListener();
		backBtn.setOnClickListener(viewOnClickListener);
		loop.setOnClickListener(viewOnClickListener);
		preBtn.setOnClickListener(viewOnClickListener);
		nextBtn.setOnClickListener(viewOnClickListener);
		playBtn.setOnClickListener(viewOnClickListener);
		lanmu.setOnClickListener(viewOnClickListener);
		mSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
		albumLayout.setOnClickListener(viewOnClickListener);
		mLrcView.setOnLrcClickListener(onLrcClickListener);
	}
	
	
	private class ViewOnClickListener implements OnClickListener{
		Intent intent = new Intent();
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.back_btn:		//返回按钮
				finish();
				break;
			case R.id.loop:		//循环模式按钮
				if (repeatAllFlag){
					loop.setBackgroundResource(R.drawable.img_appwidget91_playmode_shuffle);
					shuffleFlag = true;
					repeatAllFlag = false;
					shuffleMusic();
					Toast.makeText(PlayActivity.this,"随机播放", Toast.LENGTH_SHORT).show();
				}else if (shuffleFlag) {
					loop.setBackgroundResource(R.drawable.img_appwidget91_playmode_repeat_current);
					shuffleFlag = false;
					repeatCurrentFlag = true;
					Toast.makeText(PlayActivity.this,"单曲循环", Toast.LENGTH_SHORT).show();
					repeatOne();
				}else if (repeatCurrentFlag) {
					loop.setBackgroundResource(R.drawable.img_appwidget91_playmode_repeat_all);
					repeatCurrentFlag = false;
					repeatAllFlag = true;
					Toast.makeText(PlayActivity.this,"顺序播放", Toast.LENGTH_SHORT).show();
					repeatNone();
				}
				break;
			case R.id.alubnlayout:
				albumLayout.startAnimation(mHiddenAction);
				albumLayout.setVisibility(View.INVISIBLE);
				mLrcView.setVisibility(View.VISIBLE);
				file = new File(getPath(titleText));
				if (file.exists()){
					mLrcView.setLrcRows(getLrcRows());
				}else {
					mLrcView.setLrcRows(null);
				}
				break;
			case R.id.play_pre_btn:		//上一首
				previousMusic();
				break;
			case R.id.play_next_btn:		//下一首
				nextMusic();
				break;
			case R.id.play_play_btn:		//播放
				if (isPlaying){
					playBtn.setBackgroundResource(R.drawable.img_lockscreen_play_normal);
					intent.setAction("com.fw.media.MUSIC_SERVICE");
					intent.putExtra("MSG", AppConstant.PlayerMsg.PAUSE_MSG);
					startService(intent);
					isPlaying = false;
					isPause = true;
					playThread.setSuspend(true);
				}else if (isPause) {
					playBtn.setBackgroundResource(R.drawable.img_lockscreen_pause_normal);
					intent.setAction("com.fw.media.MUSIC_SERVICE");
					intent.putExtra("MSG", AppConstant.PlayerMsg.CONTINUE_MSG);
					startService(intent);
					isPause = false;
					isPlaying = true;
					playThread.setSuspend(false);
				}
				isFirstTime = false;
				editor.putBoolean("isPlaying", isPlaying);
				editor.putBoolean("isPause", isPause);
				editor.putBoolean("isFirstTime", isFirstTime);
				editor.commit();
				break;
			case R.id.lanmu:		//栏目按钮
				finish();
				break;
			}
		}
	}
	private class SeekBarChangeListener implements OnSeekBarChangeListener {

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			mLrcView.seekTo(progress, true,fromUser);
			if (fromUser){
				audioTrackChange(progress);		//用户控制进度的改变发送给服务器
			}
					
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			
		}
		
	}
	
	
	/**
	 *	用户手动改变进度条 
	 */
	public void audioTrackChange(int progress){
		Intent intent = new Intent();
		intent.setAction("com.fw.media.MUSIC_SERVICE");
		intent.putExtra("url", url);
		intent.putExtra("listPosition", listPosition);
		if(isPause){
			intent.putExtra("MSG", AppConstant.PlayerMsg.PAUSE_MSG);
		}else {
			intent.putExtra("MSG", AppConstant.PlayerMsg.PROGRESS_CHANGE);
		}
		intent.putExtra("progress", progress);
		startService(intent);
	}
	
	/**
	 * 播放音乐
	 */
	public void play(){
     	playBtn.setBackgroundResource(R.drawable.img_lockscreen_pause_normal);
		repeatNone();
		Intent intent = new Intent();
		intent.setAction("com.fw.media.MUSIC_SERVICE");
		intent.putExtra("url", url);
		intent.putExtra("listPosition", listPosition);
		intent.putExtra("MSG", flag);
		startService(intent);
	}
	
	/**
	 * 随机播放
	 */
	public void shuffleMusic(){
		Intent intent = new Intent(CTL_ACTION);
		intent.putExtra("control", 4);
		sendBroadcast(intent);
	}
	
	/**
	 * 单曲循环
	 */
	public void repeatOne(){
		Intent intent = new Intent(CTL_ACTION);
		intent.putExtra("control", 1);
		sendBroadcast(intent);
	}
		
	/**
	 * 顺序播放
	 */
	public void repeatNone(){
		Intent intent = new Intent(CTL_ACTION);
		intent.putExtra("control", 3);
		sendBroadcast(intent);
	}
	
	/**
	 * 上一首
	 */
	public void previousMusic(){
		listPosition = listPosition -1;
		playBtn.setBackgroundResource(R.drawable.img_lockscreen_pause_normal);
		if (listPosition >= 0){
			Mp3Info mp3Info = mp3Infos.get(listPosition);	//获得上一首Mp3
			showArtwork(mp3Info);
			titleText = mp3Info.getTitle();
			if (mLrcView.getVisibility() == View.VISIBLE){
				if (file.exists()){
					mLrcView.setLrcRows(getLrcRows());
				}else {
					mLrcView.setLrcRows(null);
				}
			}
			title.setText(mp3Info.getTitle());
			url = mp3Info.getUrl();
			Intent intent = new Intent();
			intent.setAction("com.fw.media.MUSIC_SERVICE");
			intent.putExtra("url", mp3Info.getUrl());
			intent.putExtra("listPosition", listPosition);
			intent.putExtra("MSG", AppConstant.PlayerMsg.NEXT_MSG);
			startService(intent);
			isPause = false;
			isPlaying = true;
		}else {
			Toast.makeText(PlayActivity.this,"没有上一首了", Toast.LENGTH_SHORT).show();
		}
	}
	
	/**
	 * 下一首
	 */
	public void nextMusic(){
		listPosition = listPosition + 1;
		playBtn.setBackgroundResource(R.drawable.img_lockscreen_pause_normal);
		if (listPosition <= mp3Infos.size()-1){
			Mp3Info mp3Info = mp3Infos.get(listPosition);
			showArtwork(mp3Info);
			titleText = mp3Info.getTitle();
			if (mLrcView.getVisibility() == View.VISIBLE){
				if (file.exists()){
					mLrcView.setLrcRows(getLrcRows());
				}else {
					mLrcView.setLrcRows(null);
				}
			}

			url = mp3Info.getUrl();
			title.setText(mp3Info.getTitle());
			Intent intent = new Intent();
			intent.setAction("com.fw.media.MUSIC_SERVICE");
			intent.putExtra("url", mp3Info.getUrl());
			intent.putExtra("listPosition", listPosition);
			intent.putExtra("MSG", AppConstant.PlayerMsg.NEXT_MSG);
			startService(intent);
			isPause = false;
			isPlaying = true;
		}else {
			Toast.makeText(PlayActivity.this,"没有下一首了", Toast.LENGTH_SHORT).show();
		}
	}
	
	public class PlayerReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals(MUSIC_CURRENT)){
				currentTime = intent.getIntExtra("currentTime", -1);
				startTime.setText(MediaUtils.formatTime(currentTime));
				mSeekBar.setProgress(currentTime);
			}else if (action.equals(MUSIC_DURATION)) {
				int duration = intent.getIntExtra("duration", -1);
				mSeekBar.setMax(duration);
				endTime.setText(MediaUtils.formatTime(duration));
			}else if (action.equals(UPDATE_ACTION)) {
				listPosition = intent.getIntExtra("current", -1);
				url = mp3Infos.get(listPosition).getUrl();
				if (listPosition >=0){
					title.setText(mp3Infos.get(listPosition).getTitle());
					showArtwork(mp3Infos.get(listPosition));
				}
				if (listPosition ==0){
					endTime.setText(MediaUtils.formatTime(mp3Infos.get(listPosition).getDuration()));
					isPause = true;
				}
				
			}else if (action.equals(REPEAT_ACTION)) {
				 switch (repeatState) {
				 case isCurrentRepeat: // 单曲循环  
					 
					 break;
				 case isAllRepeat: // 全部循环  
					 
					 break;
				 }
			}else if (action.equals(SHUFFLE_ACTION)) {
				isShuffle = intent.getBooleanExtra("shuffleState", false);
				 if(isShuffle) {  
	                    isNoneShuffle = false;  
	                } else {  
	                    isNoneShuffle = true;  
	                }  
				
			}  
		}
		
	}
	
	/**
	 *	将资源文件转化为Bitmap 
	 */
	 public Bitmap convertResToBm(int id){
		 BitmapFactory.Options option = new BitmapFactory.Options();
		 option.inSampleSize = 6;  //将原图缩小四分之一读取
		 option.inJustDecodeBounds = false;
		 Bitmap bm = BitmapFactory.decodeResource(getResources(),id, option);

		     return  ThumbnailUtils.extractThumbnail(bm, 480, 800); //将图片的大小限定在480*800
	 }
	 
	 
	 /**
	  *		专辑封面 旋转线程
	  */
	 class PlayThread extends Thread{
		 
		    private boolean suspend = false;  //默认运行
		    
		    private String control = ""; // 只是需要一个对象而已，这个对象没有实际意义  
		  
		    public void setSuspend(boolean suspend) {  
		        if (!suspend) {  
		            synchronized (control) {  
		                control.notifyAll();  
		            }  
		        }  
		        this.suspend = suspend;  
		    }
		    
		    public boolean isSuspend() {  
		        return this.suspend;  
		    }  
		    
		    public void run() {  
		        while (true) {  
	            	album.setDegree(album.getDegree() + 0.5f);
	                    try {
	                            Thread.sleep(20);
	                    } catch (InterruptedException e) {
	                            e.printStackTrace();
	                    }
		            synchronized (control) {  
		                if (suspend) {  
		                    try {  
		                        control.wait();  
		                    } catch (InterruptedException e) {  
		                        e.printStackTrace();  
		                    }  
		                }  
		            }  
		        }  
		    }  		 
	 }
	 
		/**
		 * 文件下载
		 */
		private void downloadFile(String url)
		{
			try {
				URL u = new URL(url);
				URLConnection conn = u.openConnection();
				conn.connect();
				InputStream is = conn.getInputStream();
				fileSize = conn.getContentLength();
				if(fileSize<1||is==null)
				{
				}else{
					FileOutputStream fos = new FileOutputStream(getPath(titleText));
					byte[] bytes = new byte[1024];
					int len = -1;
					while((len = is.read(bytes))!=-1)	// 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 bytes 中。
					{
						fos.write(bytes, 0, len);
					}
					is.close();
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		/**
		 * 得到文件的保存路径
		 * @return
		 * @throws IOException
		 */
		private String getPath(String title) {
			String path = FileUtil.setMkdir(this)+File.separator+title+".lrc";
			return path;
		}
		
		/**
		 * 解析和处理服务器返回歌词数据
		 */
		public Boolean handleLrcResponse(String response,String title){
			try {
				JSONObject jsonObject = new JSONObject(response);
				int result = jsonObject.getInt("code");
				if (result ==0){
					JSONArray jsonArray = jsonObject.getJSONArray("result");
					JSONObject jsonObject2 = (JSONObject)jsonArray.opt(0);
					String lrcAddress = jsonObject2.getString("lrc");
					Log.e("PlayActivity",lrcAddress);
					editor.putString(title, lrcAddress);
					editor.commit();
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		private void queryServer(final String title,String artist){
			String address;
			address = "http://geci.me/api/lyric/"+URLEncoder.encode(title)+"/"+URLEncoder.encode(artist);
			
			HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
				
				@Override
				public void onFinish(String response) {
					HttpResult=handleLrcResponse(response,title);
					Log.e("PlayActivity", response);
				}
				
				@Override
				public void onError(Exception e) {
					
				}
			});
		}
		
//		/**
//		 * 将播放进度的毫米数转换成时间格式
//		 * 如 3000 --> 00:03 
//		 * @param progress
//		 * @return
//		 */
//		private String formatTimeFromProgress(int progress){
//			//总的秒数 
//			int msecTotal = progress/1000;
//			int min = msecTotal/60;
//			int msec = msecTotal%60;
//			String minStr = min < 10 ? "0"+min:""+min;
//			String msecStr = msec < 10 ? "0"+msec:""+msec;
//			return minStr+":"+msecStr;
//		}
		/**
		 * 获取歌词List集合
		 * @return
		 */
		private List<LrcRow> getLrcRows(){
			List<LrcRow> rows = null;
			InputStream is=null;
			try {
				is = new FileInputStream(getPath(titleText));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line ;
			StringBuffer sb = new StringBuffer();
			try {
				while((line = br.readLine()) != null){
					sb.append(line+"\n");
				}
				System.out.println(sb.toString());
				br.close();
				rows = DefaultLrcParser.getIstance().getLrcRows(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return rows;
		}
		
		
		OnLrcClickListener onLrcClickListener = new OnLrcClickListener() {

			@Override
			public void onClick() {
				albumLayout.startAnimation(mShowAction);
				albumLayout.setVisibility(View.VISIBLE);
				mLrcView.setVisibility(View.INVISIBLE);
			}
		};
		
		
		/**
		 * 专辑封面动画
		 */
		public void setAnimate(){
	        mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,     
	                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,     
	                -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);     
	        mShowAction.setDuration(500); 
	        
	        mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF,     
                    0.0f, Animation.RELATIVE_TO_SELF, 0.0f,     
                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,     
                    -1.0f);    
	        mHiddenAction.setDuration(500);  
		}
	 
	 
}
