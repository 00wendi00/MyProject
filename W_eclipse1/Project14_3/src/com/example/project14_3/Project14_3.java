package com.example.project14_3;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Project14_3 extends Activity
{
	ImageView flower;
	Animation anim,reverse;
	final Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(msg.what ==0x123)
			{
				flower.startAnimation(reverse);
			}
		}
	};
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		flower = (ImageView)findViewById(R.id.flower);
		anim = AnimationUtils.loadAnimation(this, R.anim.anim);
		anim.setFillAfter(true);
		reverse = AnimationUtils.loadAnimation(this, R.anim.reverse);
		reverse.setFillAfter(true);
		Button bn = (Button)findViewById(R.id.bn);
		bn.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View arg0)
			{
				Intent addIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
				String title = getResources().getString(R.string.title);
				Parcelable icon = Intent.ShortcutIconResource.fromContext(Project14_3.this, R.drawable.ic_launcher);
				Intent myIntent = new Intent(Project14_3.this,Project14_3.class);
				addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, title);
				addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
				addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, myIntent);
				sendBroadcast(addIntent);
			}
		});
	}
	public void onResume()
	{
		super.onResume();
		flower.startAnimation(anim);
		new Timer().schedule(new TimerTask() {
			public void run() {
				handler.sendEmptyMessage(0x123);
			}
		}, 3500);
	}
}
