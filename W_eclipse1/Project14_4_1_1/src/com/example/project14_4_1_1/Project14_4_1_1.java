package com.example.project14_4_1_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.RemoteViews;

public class Project14_4_1_1 extends AppWidgetProvider
{
	private Timer timer = new Timer();
	private AppWidgetManager appWidgetManager;
	private Context context;
	private int[] digits = new int[]
	{
		R.drawable.su01,	
		R.drawable.su02,	
		R.drawable.su03,	
		R.drawable.su04,	
		R.drawable.su05,	
		R.drawable.su06,	
		R.drawable.su07,	
		R.drawable.su08,	
		R.drawable.su09,	
		R.drawable.su10,
	};
	private int[] digitViews = new int[]
	{
			R.id.img01,R.id.img02,R.id.img04,R.id.img05,R.id.img07,R.id.img08
	};
	public void onUpdate(Context context,AppWidgetManager appWidgetManager,int[] appwidgetIds)
	{
		System.out.println("----onUpdate----");
		this.appWidgetManager = appWidgetManager;
		this.context = context;
		timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				handler.sendEmptyMessage(0x123);
			}
		}, 0,1000);
	}
	private Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(msg.what ==0x123)
			{
				RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.main);
				SimpleDateFormat df = new SimpleDateFormat("HHmmss");
				String timeStr = df.format(new Date());
				for(int i = 0;i<timeStr.length();i++)
				{
					int num = timeStr.charAt(i)-48;
					views.setImageViewResource(digitViews[i], digits[num]);
				}
				ComponentName componentName = new ComponentName(context,Project14_4_1_1.class);
				appWidgetManager.updateAppWidget(componentName, views);
			}
			super.handleMessage(msg);
		}
	};
}
