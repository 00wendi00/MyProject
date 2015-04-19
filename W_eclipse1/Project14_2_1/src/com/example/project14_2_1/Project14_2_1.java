package com.example.project14_2_1;

import java.util.Random;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class Project14_2_1 extends WallpaperService
{
	private Bitmap heart;
	public Engine onCreateEngine() 
	{
		heart = BitmapFactory.decodeResource(getResources(), R.drawable.heart);
		return  new MyEngine();
	}
	class MyEngine extends Engine
	{
		private boolean mVisible;
		private float mTouchX = -1;
		private float mTouchY = -1;
		private int count = 1;
		private int originX = 200, originY = 200;
		private Paint mpaint = new Paint();
		Handler mHandler = new Handler();
		private final Runnable drawTarget = new Runnable() 
		{
			public void run()
			{
				drawFrame();
			}
		};
		public void onCreate(SurfaceHolder surfaceHolder)
		{
			super.onCreate(surfaceHolder);
			mpaint.setARGB(76, 0, 0, 255);
			mpaint.setAntiAlias(true);
			mpaint.setStyle(Paint.Style.FILL);
			setTouchEventsEnabled(true);
		}
		public void onDestroy()
		{
			super.onDestroy();
			mHandler.removeCallbacks(drawTarget);
		}
		public void onVisibilityChanged(boolean visible)
		{
			mVisible = visible;
			if(visible)
			{
				drawFrame();
			}
			else {
				mHandler.removeCallbacks(drawTarget);
			}
		}
		public void onOffsetsChanged(float xOffset,float yOffset,float xStep,float yStep,int xPixels,int yPixels)
		{
			drawFrame();
		}
		public void onTouchEvent(MotionEvent event)
		{
			if(event.getAction() == MotionEvent.ACTION_MOVE)
			{
				mTouchX = event.getX();
				mTouchY = event.getY();
			}
			else {
				mTouchX = -1;
				mTouchY = -1;
			}
			super.onTouchEvent(event);
		}
		private void drawFrame()
		{
			final SurfaceHolder holder = getSurfaceHolder();
			Canvas c = null;
			try {
				c = holder.lockCanvas();
				if(c != null)
				{
					c.drawColor(0xef00abcd);
					drawTouchPoint(c);
					mpaint.setAlpha(85);
					c.translate(originX, originY);
					for(int i = 0 ;i<count;i++)
					{
						c.translate(80, 0);
						c.scale(0.95f, 0.95f);
						c.rotate(20f);
						c.drawRect(0, 0, 150, 75, mpaint);
					}
				}
			}finally
			{
				if(c!=null)
					holder.unlockCanvasAndPost(c);
			}
			mHandler.removeCallbacks(drawTarget);
			if(mVisible)
			{
				count++;
				if(count>=50)
				{
					Random rand = new Random();
					count = 1;
					originX += (rand.nextInt(100)-50);
					originY +=(rand.nextInt(100)-50);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
				mHandler.postDelayed(drawTarget, 300);
			}
		}
		private void drawTouchPoint(Canvas c )
		{
			if(mTouchX >= 0 && mTouchY >=0)
			{
				mpaint.setAlpha(255);
				c.drawBitmap(heart,mTouchX,mTouchY,mpaint);
			}
		}
	}
}
