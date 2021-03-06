/**
 *文件名:MyView.java
 *项目-包:MyDrawable1,com.example.mydrawable1
 *作者:张文迪
 *时间:2015年4月18日
 */
package com.example.mydrawable1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * @author 张文迪
 * 类名:MyView
 * 类说明:
 */
public class MyView extends View{
	Bitmap bitmap = null;
	int t;
	boolean flag;
	public MyView(Context context,int  t,boolean flag) {
		super(context);
		this.t = t;
		this.flag = flag;
	}
	@SuppressLint("DrawAllocation")
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		Paint paint = new Paint();
		if(flag == true){
			bitmap = BitmapFactory.decodeResource(getResources(), t);
			canvas.drawBitmap(bitmap, 0, 0, paint);
		}else {
			canvas.drawColor(Color.GREEN);
		}
	}
}
