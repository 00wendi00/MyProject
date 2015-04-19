package com.example.project18;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Link extends Activity {
	private GameConf config;
	private GameService gameService;
	private GameView gameView;
	private Button startButton;
	private TextView timeTextView;
	private AlertDialog.Builder lostDialog;
	private AlertDialog.Builder successDialog;
	private Timer timer = new Timer();
	private int gameTime;
	private boolean isPlaying;
	// 这个 SoundPool 有点意思~~~
	SoundPool soundPool = new SoundPool(2, AudioManager.STREAM_SYSTEM, 8);
	int dis;
	private Piece selected = null;
	private Handler handler = new Handler(){
		public void handleMessage(Message msg){
			switch (msg.what) {
			case 0x123:
				timeTextView.setText("剩余时间 : "+gameTime);
				gameTime--;
				if(gameTime<0){
					stopTimer();   //~~~~~~~~~~
					isPlaying = false;
					lostDialog.show();
					return;
				}
				break;

			default:
				break;
			}
		}
	};
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		init();    //~~~~~~~~~
	}
	public void init(){
		config = new GameConf(8, 9, 2, 10, 100000, this);
		gameView = (GameView)findViewById(R.id.gameVIew);
		timeTextView = (TextView)findViewById(R.id.timeText);
		startButton = (Button)this.findViewById(R.id.startButton);
		dis = soundPool.load(this, R.raw.dis,1);
		gameService = new GameServiceImpl(this.config);
		gameView.setGameService(gameService);
		startButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startGame(GameConf.DEFAULT_TIME);
			}
		});
		this.gameView.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent e) {
				if(!isPlaying)
					return false;
				if(e.getAction() == MotionEvent.ACTION_DOWN)
					gameViewTouchDown(e);
				if(e.getAction() == MotionEvent.ACTION_UP)
					gameViewTouchUp(e);
				return false;
			}
		});
		lostDialog = createDialog("Lost","游戏失败~重新开始!!",R.drawable.lost).setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				startGame(GameConf.DEFAULT_TIME);
			}
		});
	}
	protected void onPause(){
		stopTimer();
		super.onPause();
	}
	protected void onResume(){
		if(isPlaying)
			startGame(gameTime);
		super.onResume();
	}
	private void gameViewTouchDown(MotionEvent event){
		Piece[][] pieces = gameService.getPieces();
		float touchX = event.getX();
		float touchY = event.getY();
		Piece currentPiece = gameService.findPiece(touchX,touchY);
		if(currentPiece == null)
			return;
		this.gameView.setSelectedPiece(currentPiece);
		if(this.selected == null){
			this.selected = currentPiece;
			this.gameView.postInvalidate();
			return;
		}
		if(this.selected != null){
			LinkInfo linkInfo = this.gameService.link(this.selected,currentPiece);
			if(linkInfo == null ){
				this.selected = currentPiece;
				this.gameView.postInvalidate();   //~~~~~~~~~
			}
			else {
				handleSuccessLink(linkInfo,this.selected,currentPiece,pieces);
			}
		}
	}
	private void gameViewTouchUp(MotionEvent e){
		this.gameView.postInvalidate();   //~~~~~~~~~~~
	}
	private void startGame(int gameTime){
		if(this.timer != null){
			stopTimer();
		}
		this.gameTime = gameTime;
		if(gameTime == GameConf.DEFAULT_TIME){
			gameView.startGame();
		}
		isPlaying = true;
		this.timer = new Timer();
		this.timer.schedule(new TimerTask() {
			public void run() {
				handler.sendEmptyMessage(0x123);
			}
		}, 0,1000);
	}
	
	
	private void handleSuccessLink(LinkInfo linkInfo,Piece prePiece,Piece currentPiece,Piece[][] pieces){
		this.gameView.setLinkInfo(linkInfo);
		this.gameView.setSelectedPiece(null);
		this.gameView.postInvalidate();
		pieces[prePiece.getIndexX()][prePiece.getBeginY()] = null;
		pieces[currentPiece.getBeginX()][currentPiece.getBeginY()] = null;
		this.selected = null;
		soundPool.play(dis, 1, 1, 0, 0, 1);
		if( !this.gameService.hasPieces()){
			this.successDialog.show();
			stopTimer();
			isPlaying = false;
		}
	}
	
	
	
	private AlertDialog.Builder createDialog(String title,String message,int imageResource){
		return new AlertDialog.Builder(this).setTitle(title).setMessage(message).setIcon(imageResource);
	}
	private void stopTimer(){
		this.timer.cancel();
		this.timer = null;
	}
}
















