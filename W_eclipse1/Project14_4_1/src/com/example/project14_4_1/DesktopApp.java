package com.example.project14_4_1;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

public class DesktopApp extends AppWidgetProvider
{
	public void onUpdate(Context context,AppWidgetManager appWidgetManager,int[] appWidgetIds)
	{
		RemoteViews  remoteViews = new RemoteViews(context.getPackageName(),R.layout.main);
		remoteViews.setImageViewResource(R.id.show, R.drawable.play);
		ComponentName componentName = new ComponentName(context,DesktopApp.class);
		appWidgetManager.updateAppWidget(componentName, remoteViews);
	}
}

