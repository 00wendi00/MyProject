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

	private MediaPlayer mediaPlayer;		//ý�岥��������
	private String path;		//�����ļ�·��
	private int msg;		
	private boolean isPause;		//��ͣ״̬
	private int current = 0;		//��¼��ǰ���ڲ��ŵ�����
	private List<Mp3Info> mp3Infos;		//���Mp3Info����ļ���
	private int status = 3;			//����״̬��Ĭ��Ϊ˳�򲥷�
	private MyReceiver myReceiver;		//�Զ���㲥������
	private int currentTime;		//��ǰ���Ž���
	private int duration;		//���Ž���
	
	
	
	public static final String UPDATE_ACTION = "com.music.action.UPDATE_ACTION";
    public static final String CTL_ACTION = "com.music.action.CTL_ACTION";  
    public static final String MUSIC_CURRENT = "com.music.action.MUSIC_CURRENT";  //�������ֲ���ʱ��
    public static final String MUSIC_DURATION = "com.music.action.MUSIC_DURATION";  //�����ֳ��ȸ���
	
    
    private Handler handler = new Handler(){
    	public void handleMessage(android.os.Message msg) {
    		if (msg.what == 1){
    			if (mediaPlayer !=null){
    				currentTime = mediaPlayer.getCurrentPosition();
    				Intent intent = new Intent();
    				intent.setAction(MUSIC_CURRENT);
    				intent.putExtra("currentTime", currentTime);
    				sendBroadcast(intent);
    				handler.sendEmptyMessageDelayed(1, 1000);		//����ѭ�����1s����һ��
    			}
    		}
    	};
    };
    
    public void onCreate() {
    	super.onCreate();
    	mediaPlayer = new MediaPlayer();
    	mp3Infos = MediaUtils.getMp3Infos(PlayerService.this);
    	
    	/**
    	 * �������ֲ������ʱ�ļ�����
    	 */
    	mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				if (status == 1){		//����ѭ��
					mediaPlayer.start();
				}else if (status ==3) {		//˳�򲥷�
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
				}else if (status ==4) {		//�������
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
     * ��ȡ���λ��
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
		path = intent.getStringExtra("url");		//����·��
		current = intent.getIntExtra("listPosition", -1);		//��ǰ���Ÿ�����mp3Infos��λ��
		msg = intent.getIntExtra("MSG", 0);
		if (msg == AppConstant.PlayerMsg.PLAY_MSG){		//��������
			play(0);
		}else if (msg == AppConstant.PlayerMsg.PAUSE_MSG) {		//��ͣ
			pause();
		}else if (msg == AppConstant.PlayerMsg.STOP_MSG) {		//ֹͣ
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
	 *�������� 
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
	 * ��ͣ����
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
	 * ��һ��
	 */
	private void previous(){
		Intent sendIntent = new Intent(UPDATE_ACTION);
		sendIntent.putExtra("current", current);
		//���͹㲥������Activity����е�BroadcastReceiver����
		sendBroadcast(sendIntent);
		play(0);
	}
	
	/**
	 * ��һ��
	 */
	private void next(){
		Intent sendIntent = new Intent(UPDATE_ACTION);
		sendIntent.putExtra("current", current);
		sendBroadcast(sendIntent);
		play(0);
	}
	
	/**
	 * ֹͣ����
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
	 * ʵ��һ��OnpreparLister�ӿڣ�������׼���õ�ʱ��ʼ����
	 */
	private final class PreparedListener implements OnPreparedListener{

		private int currentTime;
		
		public PreparedListener(int currentTime){
			this.currentTime = currentTime;
		}
		
		@Override
		public void onPrepared(MediaPlayer mp) {
			mediaPlayer.start();
			if (currentTime >0){	//������ֲ��Ǵ�ͷ����
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
				status = 1;		//����״̬����Ϊ1������ѭ��
				break;
			case 3:
				status = 3;		//����״̬����Ϊ3��˳�򲥷�
				break;
			case 4:
				status = 4;		//����״̬����Ϊ4���������
				break;
			}
		}
		
	}
		
}
