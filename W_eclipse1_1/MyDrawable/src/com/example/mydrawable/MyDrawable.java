package com.example.mydrawable;

import java.util.Timer;
import java.util.TimerTask;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MyDrawable extends ActionBarActivity {
	//String[] images= null;
	//AssetInputStream assets = null;
	Button buttonStart;
	GridLayout gridLayout;
	int width;
	int height;
	int[] k =  {0,1,2,5,8,7,6,3};
	/*int[] ID = {R.drawable.a123,R.drawable.aaa,R.drawable.ddd,R.drawable.fff,
			R.drawable.ggg,R.drawable.hhh,R.drawable.iii,R.drawable.jjj};*/
	
	@SuppressLint({ "HandlerLeak", "NewApi" })
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_drawable);
		
		//���ַ��������� ��
		//WindowManager wm1 = this.getWindowManager();  
		//int width1 = wm1.getDefaultDisplay().getWidth();  
		//int height1 = wm1.getDefaultDisplay().getHeight();  
		//��ȡ��Ļ ����
		WindowManager manager = this.getWindowManager();  
		DisplayMetrics outMetrics = new DisplayMetrics();  
		manager.getDefaultDisplay().getMetrics(outMetrics);  
		width = outMetrics.widthPixels;  
		height = outMetrics.heightPixels;

		width = width/3 *6/10;
		height = height/3 *6/10;
		
		buttonStart = (Button)findViewById(R.id.buttonS);
		gridLayout = (GridLayout)findViewById(R.id.haode);
		
		/*for(int i = 0;i<8;i++){
			ImageView imageView = new ImageView(this);
			imageView.setImageResource(R.drawable.aa);
			imageView.setScaleType(ScaleType.FIT_XY);
			if(i>=4)
				i++;
			GridLayout.Spec rowSpec = GridLayout.spec(i/3); 
			GridLayout.Spec columnSpec = GridLayout.spec(i%3);
			GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec,columnSpec);
			params.height =height/3 *6/10;
			params.width = width/3 *6/10;
			//params.setGravity(Gravity.FILL); 
			gridLayout.addView(imageView,params);
			if(i>4)
				i--;
		}*/

		/*for(int i = 0;i<ID.length;i++){
			ImageView imageView = new ImageView(this);
			imageView.setImageResource(ID[i]);
			GridLayout.Spec rowSpec = GridLayout.spec(i/3); 
			GridLayout.Spec columnSpec = GridLayout.spec(i%3);
			GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec,columnSpec);
			params.setGravity(Gravity.FILL); 
			gridLayout.addView(imageView,params);
		}*/
		buttonStart.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				ImageView imageView = new ImageView(MyDrawable.this);
				imageView.setImageResource(R.drawable.bb);
				imageView.setScaleType(ScaleType.FIT_CENTER);
				GridLayout.Spec rowSpec = GridLayout.spec(2);
				GridLayout.Spec columnSpec  = GridLayout.spec(2);
				GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec,columnSpec);
				//params.height =height;
				//params.width = width;
				//params.setGravity(Gravity.FILL); 
				gridLayout.addView(imageView,params);
			}
		});
		
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
					
					ImageView imageView = new ImageView(MyDrawable.this);
					imageView.setImageResource(R.drawable.bb);
					imageView.setScaleType(ScaleType.FIT_CENTER);
					GridLayout.Spec rowSpec = GridLayout.spec(k[p1]/3);
					GridLayout.Spec columnSpec  = GridLayout.spec(k[p1]%3);
					GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec,columnSpec);
					//params.height =height;
					//params.width = width;
					//params.setGravity(Gravity.FILL); 
					gridLayout.addView(imageView,params);
					
					ImageView imageView1 = new ImageView(MyDrawable.this);
					imageView1.setImageResource(R.drawable.aa);
					imageView1.setScaleType(ScaleType.FIT_CENTER);
					GridLayout.Spec rowSpec1 = GridLayout.spec(k[p2]/3);
					GridLayout.Spec columnSpec1  = GridLayout.spec(k[p2]%3);
					GridLayout.LayoutParams params1 = new GridLayout.LayoutParams(rowSpec1,columnSpec1);
					//params.height =height ;
					//params.width = width;
					//params.setGravity(Gravity.FILL); 
					gridLayout.addView(imageView1,params1);
					
					
				}
			}
		};
		
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
					handler.sendEmptyMessage(0x123);
			}
		}, 0,50);
		
		
		
	}
	
}