package com.example.mydrawable1;

import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.GridLayout;

//�Լ�����ֹ��~~  �������߳�~~ ����
public class MyDrawable1 extends Activity {
	GridLayout gridLayout;
	int width,height;
	int[] k =  {0,1,2,5,8,7,6,3};
	@SuppressLint("HandlerLeak")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_drawable1);
		gridLayout = (GridLayout)findViewById(R.id.haode);
		
		WindowManager manager = this.getWindowManager();  
		DisplayMetrics outMetrics = new DisplayMetrics();  
		manager.getDefaultDisplay().getMetrics(outMetrics);  
		width = outMetrics.widthPixels;  
		height = outMetrics.heightPixels;
		/*for(int i = 0 ;i<8;i++){
			if(i>=4)
				i++;
			GridLayout.Spec rowSpec = GridLayout.spec(i/3);
			GridLayout.Spec columnSpec  = GridLayout.spec(i%3);
			GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec,columnSpec);
			params.setGravity(Gravity.CENTER);
			params.width = width/3*9/10;
			params.height = height/3*9/10;
			gridLayout.addView(new MyView(this,R.drawable.aa),params);
			if(i>4)
				i--;
		}*/
				
		
		
		
		final Handler handler = new Handler(){
			int m = 0;
			int p1 = 0;
			int p2 = 0;
			public void handleMessage(Message msg){
				if (msg.what==0x123) {
					m++;
					if (m>7) {
						m=0;
						p1 = m;
						p2 = 7;
					}else {
						p1 = m; 
						p2 = m-1;
					}
					
					GridLayout.Spec rowSpec = GridLayout.spec(k[p1]/3);
					GridLayout.Spec columnSpec  = GridLayout.spec(k[p1]%3);
					GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec,columnSpec);
					params.setGravity(Gravity.CENTER);
					params.width = width/3*9/10;
					params.height = height/3*9/10;
					gridLayout.addView(new MyView(MyDrawable1.this,R.drawable.bb,true),params);
					
					GridLayout.Spec rowSpec1 = GridLayout.spec(k[p2]/3);
					GridLayout.Spec columnSpec1  = GridLayout.spec(k[p2]%3);
					GridLayout.LayoutParams params1 = new GridLayout.LayoutParams(rowSpec1,columnSpec1);
					params1.setGravity(Gravity.CENTER);
					params1.width = width/3*9/10;
					params1.height = height/3*9/10;
					gridLayout.addView(new MyView(MyDrawable1.this,R.drawable.aa,false),params1);
					
					
				}
			}
		};
		
		new Timer().schedule(new TimerTask() {		
			@Override
			public void run() {
				handler.sendEmptyMessage(0x123);
			}
		},0,300);
		
	}
}