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
	
	private SeekBar mSeekBar;		//������
	private RelativeLayout playActivityLayout;		//����ҳ������
	private RelativeLayout albumLayout;
	private Bitmap bm;
	private ImageView backBtn;		//���ذ�ť
	private TextView title;			//��������
	private CircleImageView album;		//ר��Բ�η���
	private ImageView loop;			//ѭ��ģʽ��ť
	private ImageView nextBtn;		//��һ��
	private ImageView playBtn;		//���ţ����š���ͣ��
	private ImageView preBtn;		//��һ��
	private ImageView lanmu;		//��Ŀ��ť
	private TextView startTime;		//������ǰ��ʱ��
	private TextView endTime;		//����������ʱ��
	private float degree;
	private String artist;
	boolean clickFlag = true;
	boolean repeatCurrentFlag = false;
	boolean shuffleFlag = false;
	boolean repeatAllFlag = true;
	
	private String titleText;	//��������
    private String url;         //����·��  
    private int listPosition;   //���Ÿ�����mp3Infos��λ��  
    private int currentTime;    //��ǰ��������ʱ��  
    private long duration;       //��������  
    private int flag;           //���ű�ʶ  
    private int repeatState;  
    private final int isCurrentRepeat = 1; // ����ѭ��  
    private final int isAllRepeat = 2;      // ȫ��ѭ��  
    private boolean isFirstTime = true;
    private boolean isPlaying;              // ���ڲ���  
    private boolean isPause;                // ��ͣ  
    private boolean isNoneShuffle;           // ˳�򲥷�  
    private boolean isShuffle;          // �������  
    private PlayerReceiver playerReceiver;
	private SharedPreferences pref;
	private SharedPreferences.Editor editor;
	private PlayThread playThread;
	private int fileSize = 0;		//�ļ�һ���Ĵ�С
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
    public static final String UPDATE_ACTION = "com.music.action.UPDATE_ACTION";  //���¶���  
    public static final String CTL_ACTION = "com.music.action.CTL_ACTION";        //���ƶ���  
    public static final String MUSIC_CURRENT = "com.music.action.MUSIC_CURRENT";  //���ֵ�ǰʱ��ı䶯��  
    public static final String MUSIC_DURATION = "com.music.action.MUSIC_DURATION";//���ֲ��ų��ȸı䶯��  
    public static final String MUSIC_PLAYING = "com.music.action.MUSIC_PLAYING";  //�������ڲ��Ŷ���  
    public static final String REPEAT_ACTION = "com.music.action.REPEAT_ACTION";  //�����ظ����Ŷ���  
    public static final String SHUFFLE_ACTION = "com.music.action.SHUFFLE_ACTION";//����������Ŷ���  
      

	
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
	 * ��onResume�г�ʼ���ͽ���Activity����
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
	 * ��ʾר������
	 */
	private void showArtwork(Mp3Info mp3Info) {
		Bitmap bm = MediaUtils.getArtwork(this, mp3Info.getId(), mp3Info.getAlbumId(), true, false);
		if(bm != null) {
			album.setImageBitmap(bm);	//��ʾר������ͼƬ
		} else {
			bm = MediaUtils.getDefaultArtwork(this, false);
			album.setImageBitmap(bm);	//��ʾר������ͼƬ
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
			case R.id.back_btn:		//���ذ�ť
				finish();
				break;
			case R.id.loop:		//ѭ��ģʽ��ť
				if (repeatAllFlag){
					loop.setBackgroundResource(R.drawable.img_appwidget91_playmode_shuffle);
					shuffleFlag = true;
					repeatAllFlag = false;
					shuffleMusic();
					Toast.makeText(PlayActivity.this,"�������", Toast.LENGTH_SHORT).show();
				}else if (shuffleFlag) {
					loop.setBackgroundResource(R.drawable.img_appwidget91_playmode_repeat_current);
					shuffleFlag = false;
					repeatCurrentFlag = true;
					Toast.makeText(PlayActivity.this,"����ѭ��", Toast.LENGTH_SHORT).show();
					repeatOne();
				}else if (repeatCurrentFlag) {
					loop.setBackgroundResource(R.drawable.img_appwidget91_playmode_repeat_all);
					repeatCurrentFlag = false;
					repeatAllFlag = true;
					Toast.makeText(PlayActivity.this,"˳�򲥷�", Toast.LENGTH_SHORT).show();
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
			case R.id.play_pre_btn:		//��һ��
				previousMusic();
				break;
			case R.id.play_next_btn:		//��һ��
				nextMusic();
				break;
			case R.id.play_play_btn:		//����
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
			case R.id.lanmu:		//��Ŀ��ť
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
				audioTrackChange(progress);		//�û����ƽ��ȵĸı䷢�͸�������
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
	 *	�û��ֶ��ı������ 
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
	 * ��������
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
	 * �������
	 */
	public void shuffleMusic(){
		Intent intent = new Intent(CTL_ACTION);
		intent.putExtra("control", 4);
		sendBroadcast(intent);
	}
	
	/**
	 * ����ѭ��
	 */
	public void repeatOne(){
		Intent intent = new Intent(CTL_ACTION);
		intent.putExtra("control", 1);
		sendBroadcast(intent);
	}
		
	/**
	 * ˳�򲥷�
	 */
	public void repeatNone(){
		Intent intent = new Intent(CTL_ACTION);
		intent.putExtra("control", 3);
		sendBroadcast(intent);
	}
	
	/**
	 * ��һ��
	 */
	public void previousMusic(){
		listPosition = listPosition -1;
		playBtn.setBackgroundResource(R.drawable.img_lockscreen_pause_normal);
		if (listPosition >= 0){
			Mp3Info mp3Info = mp3Infos.get(listPosition);	//�����һ��Mp3
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
			Toast.makeText(PlayActivity.this,"û����һ����", Toast.LENGTH_SHORT).show();
		}
	}
	
	/**
	 * ��һ��
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
			Toast.makeText(PlayActivity.this,"û����һ����", Toast.LENGTH_SHORT).show();
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
				 case isCurrentRepeat: // ����ѭ��  
					 
					 break;
				 case isAllRepeat: // ȫ��ѭ��  
					 
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
	 *	����Դ�ļ�ת��ΪBitmap 
	 */
	 public Bitmap convertResToBm(int id){
		 BitmapFactory.Options option = new BitmapFactory.Options();
		 option.inSampleSize = 6;  //��ԭͼ��С�ķ�֮һ��ȡ
		 option.inJustDecodeBounds = false;
		 Bitmap bm = BitmapFactory.decodeResource(getResources(),id, option);

		     return  ThumbnailUtils.extractThumbnail(bm, 480, 800); //��ͼƬ�Ĵ�С�޶���480*800
	 }
	 
	 
	 /**
	  *		ר������ ��ת�߳�
	  */
	 class PlayThread extends Thread{
		 
		    private boolean suspend = false;  //Ĭ������
		    
		    private String control = ""; // ֻ����Ҫһ��������ѣ��������û��ʵ������  
		  
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
		 * �ļ�����
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
					while((len = is.read(bytes))!=-1)	// ���������ж�ȡһ���������ֽڣ�������洢�ڻ��������� bytes �С�
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
		 * �õ��ļ��ı���·��
		 * @return
		 * @throws IOException
		 */
		private String getPath(String title) {
			String path = FileUtil.setMkdir(this)+File.separator+title+".lrc";
			return path;
		}
		
		/**
		 * �����ʹ�����������ظ������
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
//		 * �����Ž��ȵĺ�����ת����ʱ���ʽ
//		 * �� 3000 --> 00:03 
//		 * @param progress
//		 * @return
//		 */
//		private String formatTimeFromProgress(int progress){
//			//�ܵ����� 
//			int msecTotal = progress/1000;
//			int min = msecTotal/60;
//			int msec = msecTotal%60;
//			String minStr = min < 10 ? "0"+min:""+min;
//			String msecStr = msec < 10 ? "0"+msec:""+msec;
//			return minStr+":"+msecStr;
//		}
		/**
		 * ��ȡ���List����
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
		 * ר�����涯��
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
