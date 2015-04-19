package com.example.music.service;

import java.util.List;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.IBinder;

import com.example.music.activity.PlayActivity;
import com.example.music.modle.AppConstant;
import com.example.music.modle.Mp3Info;
import com.example.music.utils.MediaUtils;

public class PlayerService extends Service {

	private MediaPlayer mediaPlayer;		//媒体播放器对象
	private String path;		//音乐文件路径
	private int msg;		
	private boolean isPause;		//暂停状态
	private int current = 0;		//记录当前正在播放的音乐
	private List<Mp3Info> mp3Infos;		//存放Mp3Info对象的集合
	private int status = 3;			//播放状态，默认为顺序播放
	private MyReceiver myReceiver;		//自定义广播接收器
	private int currentTime;		//当前播放进度
	private int duration;		//播放进度
	
	
	
	public static final String UPDATE_ACTION = "com.music.action.UPDATE_ACTION";
    public static final String CTL_ACTION = "com.music.action.CTL_ACTION";  
    public static final String MUSIC_CURRENT = "com.music.action.MUSIC_CURRENT";  //更新音乐播放时间
    public static final String MUSIC_DURATION = "com.music.action.MUSIC_DURATION";  //新音乐长度更新
	
    
    private Handler handler = new Handler(){
    	public void handleMessage(android.os.Message msg) {
    		if (msg.what == 1){
    			if (mediaPlayer !=null){
    				currentTime = mediaPlayer.getCurrentPosition();
    				Intent intent = new Intent();
    				intent.setAction(MUSIC_CURRENT);
    				intent.putExtra("currentTime", currentTime);
    				sendBroadcast(intent);
    				handler.sendEmptyMessageDelayed(1, 1000);		//自身循环间隔1s发送一次
    			}
    		}
    	};
    };
    
    public void onCreate() {
    	super.onCreate();
    	mediaPlayer = new MediaPlayer();
    	mp3Infos = MediaUtils.getMp3Infos(PlayerService.this);
    	
    	/**
    	 * 设置音乐播放完成时的监听器
    	 */
    	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				if (status == 1){		//单曲循环
					mediaPlayer.start();
				}else if (status ==3) {		//顺序播放
					current++;
					if (current <mp3Infos.size() -1){
						Intent intent = new Intent(UPDATE_ACTION);
						intent.putExtra("current", current);
						sendBroadcast(intent);
						path = mp3Infos.get(current).getUrl();
						play(0);
					}else {
						mediaPlayer.seekTo(0);
						current = 0;
						Intent intent = new Intent(UPDATE_ACTION);
						intent.putExtra("current", current);
						sendBroadcast(intent);
					}
				}else if (status ==4) {		//随机播放
					current = getRandomIndex(mp3Infos.size() -1);
					Intent intent = new Intent(UPDATE_ACTION);
					intent.putExtra("current", current);
					sendBroadcast(intent);
					path = mp3Infos.get(current).getUrl();
					play(0);
					
				}
			}
		});
    	
    	myReceiver = new MyReceiver();
    	IntentFilter filter = new IntentFilter();
    	filter.addAction(PlayActivity.CTL_ACTION);
    	registerReceiver(myReceiver, filter);
    	
    }
    
    /**
     * 获取随机位置
     * @param end
     * @return
     */
    protected int getRandomIndex(int end){
    	int index = (int)(Math.random()*end);
    	return index;
    }
    
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		path = intent.getStringExtra("url");		//歌曲路径
		current = intent.getIntExtra("listPosition", -1);		//当前播放歌曲在mp3Infos的位置
		msg = intent.getIntExtra("MSG", 0);
		if (msg == AppConstant.PlayerMsg.PLAY_MSG){		//播放音乐
			play(0);
		}else if (msg == AppConstant.PlayerMsg.PAUSE_MSG) {		//暂停
			pause();
		}else if (msg == AppConstant.PlayerMsg.STOP_MSG) {		//停止
			stop();
		}else if (msg == AppConstant.PlayerMsg.CONTINUE_MSG) {
			resume();
		}else if (msg == AppConstant.PlayerMsg.PRIVIOUS_MSG ) {
			previous();
		}else if (msg == AppConstant.PlayerMsg.NEXT_MSG) {
			next();
		}else if (msg == AppConstant.PlayerMsg.PROGRESS_CHANGE) {
			currentTime = intent.getIntExtra("progress", -1);
			play(currentTime);
		}else if (msg == AppConstant.PlayerMsg.PLAYING_MSG) {
			handler.sendEmptyMessage(1);
		}
		super.onStart(intent, startId);
	}
	
	/**
	 *播放音乐 
	 */
	private void play(int currentTime){
		try {
			mediaPlayer.reset();
			mediaPlayer.setDataSource(path);
			mediaPlayer.prepareAsync();
			mediaPlayer.setOnPreparedListener(new PreparedListener(currentTime));
			handler.sendEmptyMessage(1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 暂停音乐
	 */
	private void pause(){
		if (mediaPlayer !=null && mediaPlayer.isPlaying()){
			mediaPlayer.pause();
			isPause = true;
		}
	}
	
	private void resume(){
		if (isPause){
			mediaPlayer.start();
			isPause = false;
		}
	}
	
	/**
	 * 上一首
	 */
	private void previous(){
		Intent sendIntent = new Intent(UPDATE_ACTION);
		sendIntent.putExtra("current", current);
		//发送广播，将被Activity组件中的BroadcastReceiver接受
		sendBroadcast(sendIntent);
		play(0);
	}
	
	/**
	 * 下一首
	 */
	private void next(){
		Intent sendIntent = new Intent(UPDATE_ACTION);
		sendIntent.putExtra("current", current);
		sendBroadcast(sendIntent);
		play(0);
	}
	
	/**
	 * 停止音乐
	 */
	private void stop(){
		if (mediaPlayer != null){
			mediaPlayer.stop();
			try {
				mediaPlayer.prepare();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void onDestroy() {
		if (mediaPlayer != null){
			mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer = null;
		}
	}
	
	/**
	 * 实现一个OnpreparLister接口，当音乐准备好的时候开始播放
	 */
	private final class PreparedListener implements OnPreparedListener{

		private int currentTime;
		
		public PreparedListener(int currentTime){
			this.currentTime = currentTime;
		}
		
		@Override
		public void onPrepared(MediaPlayer mp) {
			mediaPlayer.start();
			if (currentTime >0){	//如果音乐不是从头播放
				mediaPlayer.seekTo(currentTime);
			}
			Intent intent = new Intent();
			intent.setAction(MUSIC_DURATION);
			duration = mediaPlayer.getDuration();
			intent.putExtra("duration", duration);
			sendBroadcast(intent);
		}
	}
	
	public class MyReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			int control = intent.getIntExtra("control",-1);
			switch (control) {
			case 1:
				status = 1;		//播放状态设置为1：单曲循环
				break;
			case 3:
				status = 3;		//播放状态设置为3：顺序播放
				break;
			case 4:
				status = 4;		//播放状态设置为4：随机播放
				break;
			}
		}
		
	}
		
}
