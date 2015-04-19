package com.example.music.activity;

import java.util.List;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.music.R;
import com.example.music.adapter.MyBaseAdapter;
import com.example.music.modle.AppConstant;
import com.example.music.modle.Mp3Info;
import com.example.music.utils.MediaUtils;

public class HomeActivity extends Activity {
	
	private ImageView album;
	private RelativeLayout homeRelativeLayout;
	private ListView mMusiclist;	//音乐列表
	private List<Mp3Info> mp3Infos = null; 
	private TextView songTextView;		//歌曲标题
	private TextView songerTextView;	//歌手名称
	private ImageView nextBtn;		//下一首
	private ImageView preBtn;		//上一首
	private ImageView playBtn;		//播放(播放、暂停)
	private ImageView musicSelect;
	private ImageView tmpMusicSelect;
	private Boolean tmpState;
	
	private boolean isFirstTime = true;
	private boolean isPlaying ;		//正在播放
	private boolean isPause;		//暂停
	
	private int listPosition = 0;		//标识列表位置
	private int tmplistPosition ;
	private HomeReceiver homeReceiver;
	private Drawable playDrawable;
	private SharedPreferences pref;
	private SharedPreferences.Editor editor;
	private MyBaseAdapter baseAdapter;
	
	public static final String UPDATE_ACTION = "com.music.action.UPDATE_ACTION";
    public static final String CTL_ACTION = "com.music.action.CTL_ACTION";  
    public static final String MUSIC_CURRENT = "com.music.action.MUSIC_CURRENT";  
    public static final String MUSIC_DURATION = "com.music.action.MUSIC_DURATION";  
    public static final String REPEAT_ACTION = "com.music.action.REPEAT_ACTION";  
    public static final String SHUFFLE_ACTION = "com.music.action.SHUFFLE_ACTION"; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);
	    mMusiclist = (ListView) findViewById(R.id.music_list);  
        mMusiclist.setOnItemClickListener(new MusicListItemClickListener());  
        mp3Infos = MediaUtils.getMp3Infos(getApplicationContext());  //获取歌曲对象集合  
        baseAdapter = new MyBaseAdapter(mp3Infos);
        mMusiclist.setAdapter(baseAdapter);    //显示歌曲列表  
        pref = getSharedPreferences("data", MODE_PRIVATE);
        editor = pref.edit();
        
        finViewById();
        setViewOnclickListener();
        
        homeReceiver = new HomeReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(UPDATE_ACTION);  
        filter.addAction(MUSIC_CURRENT);  
        filter.addAction(MUSIC_DURATION);  
        filter.addAction(REPEAT_ACTION);  
        filter.addAction(SHUFFLE_ACTION);
        registerReceiver(homeReceiver, filter);
}
	
	@Override
	protected void onDestroy() {
		unregisterReceiver(homeReceiver);
		super.onDestroy();
	}
	

	
	@Override
	protected void onResume() {
		super.onResume();
		if (playDrawable !=null){
			playBtn.setBackground(playDrawable);
		}
		isFirstTime = pref.getBoolean("isFirstTime", true);
		isPause = pref.getBoolean("isPause", true);
		isPlaying = pref.getBoolean("isPlaying", false);
		listPosition = pref.getInt("listPosition", 0);
		if (isPlaying){
			playBtn.setBackgroundResource(R.drawable.img_lockscreen_pause_normal);
		}else if (isPause) {
			playBtn.setBackgroundResource(R.drawable.img_lockscreen_play_normal);
		}
		songTextView.setText(mp3Infos.get(pref.getInt("listPosition", 0)).getTitle());
		songerTextView.setText(mp3Infos.get(pref.getInt("listPosition", 0)).getArtist());
		Mp3Info mp3Info = mp3Infos.get(listPosition);
		showArtwork(mp3Info);
		mp3Infos.get(listPosition).setState(true);
		
	}
	@Override
	protected void onStop() {
		super.onStop();
		playDrawable=playBtn.getBackground();
		tmplistPosition = listPosition;
		editor.putInt("listPosition", listPosition);
		editor.putBoolean("isFirstTime", isFirstTime);
		editor.commit();
	}
	
	
	public void finViewById(){
		songTextView = (TextView) findViewById(R.id.song);
		songerTextView = (TextView) findViewById(R.id.songer);
		nextBtn = (ImageView) findViewById(R.id.next_btn);
		preBtn = (ImageView) findViewById(R.id.pre_btn);
		playBtn = (ImageView) findViewById(R.id.play_btn);
		album = (ImageView) findViewById(R.id.album);
		homeRelativeLayout = (RelativeLayout) findViewById(R.id.home_relativeLayout);
	}
	
	/** 
     * 给每一个按钮设置监听器 
     */  
    private void setViewOnclickListener() {  
    	ViewOnClickListener viewOnClickListener = new ViewOnClickListener();
    	nextBtn.setOnClickListener(viewOnClickListener);
    	preBtn.setOnClickListener(viewOnClickListener);
    	playBtn.setOnClickListener(viewOnClickListener);
    	album.setOnClickListener(viewOnClickListener);
    	homeRelativeLayout.setOnClickListener(viewOnClickListener);
    	
    }
	
    private class ViewOnClickListener implements OnClickListener {
    	Intent intent = new Intent();
    	
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.pre_btn:		//上一首
				playBtn.setBackgroundResource(R.drawable.img_lockscreen_pause_normal);
				isFirstTime = false;
				isPlaying = true;
				isPause = false;
				previous();
				break;
			case R.id.home_relativeLayout:
				playMusic(listPosition);
				break;
			case R.id.album:
				playMusic(listPosition);
				break;
			case R.id.play_btn:
				if (isFirstTime){
					play();
					isFirstTime = false;
					isPlaying = true;
					isPause = false;
				}else {
					if(isPlaying){
						playBtn.setBackgroundResource(R.drawable.img_lockscreen_play_normal);
					    intent.setAction("com.fw.media.MUSIC_SERVICE");
						intent.putExtra("MSG", AppConstant.PlayerMsg.PAUSE_MSG);
						startService(intent);
						isPlaying = false;
						isPause = true;
					}else if (isPause) {
						playBtn.setBackgroundResource(R.drawable.img_lockscreen_pause_normal);
						intent.setAction("com.fw.media.MUSIC_SERVICE");
						intent.putExtra("MSG", AppConstant.PlayerMsg.CONTINUE_MSG);
						startService(intent);
						isPause = false;
						isPlaying = true;
					}
				}
				editor.putBoolean("isPlaying", isPlaying);
				editor.putBoolean("isPause", isPause);
				editor.commit();
				break;
				case R.id.next_btn:
					playBtn.setBackgroundResource(R.drawable.img_lockscreen_pause_normal);
					isFirstTime = false;
					isPlaying = true;
					isPause = false;
					next();
					break;
			}
		}  
    }
    
    
	/**
	 * 显示专辑封面
	 */
	private void showArtwork(Mp3Info mp3Info) {
		Bitmap bm = MediaUtils.getArtwork(this, mp3Info.getId(), mp3Info.getAlbumId(), true, true);
		if(bm != null) {
			album.setImageBitmap(bm);	//显示专辑封面图片
		} else {
			bm = MediaUtils.getDefaultArtwork(this, false);
			album.setImageBitmap(bm);	//显示专辑封面图片
		}
	}
//    /** 
//     * 填充列表 
//     *  
//     * @param mp3Infos 
//     */  
//    public void setListAdpter(List<HashMap<String, String>> mp3list) {  
//        mAdapter = new SimpleAdapter(this, mp3list,  
//                R.layout.music_list_item, new String[] { "title",  
//                        "Artist" }, new int[] { R.id.music_title,  
//                        R.id.music_Artist });  
//        mMusiclist.setAdapter(mAdapter);  
//    }  
    
    private class MusicListItemClickListener implements OnItemClickListener { 
    	

        @Override  
        public void onItemClick(AdapterView<?> parent, View view, int position,  
                long id) {  
        	musicSelect=(ImageView) view.findViewById(R.id.music_select);
            listPosition = position;            
            showArtwork(mp3Infos.get(listPosition));
            playBtn.setBackgroundResource(R.drawable.img_lockscreen_pause_normal);
            for (int i=0;i<mp3Infos.size();i++){
            	mp3Infos.get(i).setState(false);
            }
			for (int i = 0; i < parent.getChildCount(); i++){
				tmpMusicSelect = (ImageView) (parent.getChildAt(i).findViewById(R.id.music_select));
				tmpMusicSelect.setVisibility(View.INVISIBLE);
			}
            mp3Infos.get(listPosition).setState(true);
            musicSelect.setVisibility(View.VISIBLE);
			isFirstTime = false;
			isPlaying = true;
			isPause = false;
			editor.putBoolean("isPlaying", isPlaying);
			editor.putBoolean("isPause", isPause);
			editor.putInt("listPosition", listPosition);
			editor.putInt("position", position);
			editor.commit();
			play();          
        }  
  
    } 
    
    public void playMusic(int listPosition){
    	if (mp3Infos != null){
    		Mp3Info mp3Info = mp3Infos.get(listPosition);
    		songTextView.setText(mp3Info.getTitle());
    		songerTextView.setText(mp3Info.getArtist());
    		Intent intent = new Intent(HomeActivity.this,PlayActivity.class);
    		intent.putExtra("title", mp3Info.getTitle());
    		intent.putExtra("url", mp3Info.getUrl());
    		intent.putExtra("artist", mp3Info.getArtist());
    		intent.putExtra("listPosition", listPosition);
    		intent.putExtra("isPlaying", isPlaying);
    		intent.putExtra("isPause", isPause);
    		intent.putExtra("duration", mp3Info.getDuration());
    		intent.putExtra("MSG", AppConstant.PlayerMsg.PLAY_MSG);
    		startActivity(intent);
    	}
    }
    
   	  
	  /**
	   *下一首歌曲 
	   */
	  public void next(){
		  listPosition = listPosition + 1;
		  if(listPosition<=mp3Infos.size()-1){
			  Mp3Info mp3Info = mp3Infos.get(listPosition);
			  showArtwork(mp3Info);
			  songTextView.setText(mp3Info.getTitle());
			  songerTextView.setText(mp3Info.getArtist());
			  Intent intent = new Intent();
			  intent.setAction("com.fw.media.MUSIC_SERVICE");
			  intent.putExtra("listPosition", listPosition);
			  intent.putExtra("url", mp3Info.getUrl());
			  intent.putExtra("MSG", AppConstant.PlayerMsg.NEXT_MSG);
			  startService(intent);
		  }else {
			Toast.makeText(HomeActivity.this, "没有下一首了", Toast.LENGTH_SHORT).show();
		}
	  }
	  
	  /**
	   *上一首歌曲 
	   */
	  public void previous(){
		  listPosition = listPosition-1;
		  if (listPosition>=0){
			  Mp3Info mp3Info = mp3Infos.get(listPosition);
			  showArtwork(mp3Info);
			  songTextView.setText(mp3Info.getTitle());
			  songerTextView.setText(mp3Info.getArtist());
			  Intent intent = new Intent();
			  intent.setAction("com.fw.media.MUSIC_SERVICE");
			  intent.putExtra("listPosition", listPosition);
			  intent.putExtra("url", mp3Info.getUrl());
			  intent.putExtra("MSG", AppConstant.PlayerMsg.PRIVIOUS_MSG); 
			  startService(intent);
		  }else {
			  Toast.makeText(HomeActivity.this, "没有上一首了", Toast.LENGTH_SHORT).show();
		}
	  }
	  
	  public void play(){
		  playBtn.setBackgroundResource(R.drawable.img_lockscreen_pause_normal);
		  Mp3Info mp3Info = mp3Infos.get(listPosition);
		  songTextView.setText(mp3Info.getTitle());
		  songerTextView.setText(mp3Info.getArtist());
		  Intent intent = new Intent();
		  intent.setAction("com.fw.media.MUSIC_SERVICE");
		  intent.putExtra("listPosition", listPosition);
		  intent.putExtra("url", mp3Info.getUrl());
		  intent.putExtra("MSG", AppConstant.PlayerMsg.PLAY_MSG); 
		  startService(intent);
	  }
	  
	
	  
	  /**
	   *自定义广播接收器，接受服务器返回的广播信息
	   */
	  public class HomeReceiver extends BroadcastReceiver{
		  
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals(UPDATE_ACTION)) {
				listPosition = intent.getIntExtra("current", -1);
				if (listPosition>=0){
					songTextView.setText(mp3Infos.get(listPosition).getTitle());
					songerTextView.setText(mp3Infos.get(listPosition).getArtist());
				}
			}
		}
	  }
	  

	
}
