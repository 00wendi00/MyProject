package org.crazyit.resProject6_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * Description: <br/>
 * site: <a href="http://www.crazyit.org">crazyit.org</a> <br/>
 * Copyright (C), 2001-2012, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class RawResTest extends Activity
{
	MediaPlayer mediaPlayer1 = null;
	MediaPlayer mediaPlayer2 = null;
	String result = "";

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 直接根据声音文件的ID来创建MediaPlayer。  静态方法创建~~
		mediaPlayer1 = MediaPlayer.create(this, R.raw.bomb);
		// 获取该应用的AssetManager
		AssetManager am = getAssets();
		try
		{
			// 获取指定文件对应的AssetFileDescriptor。
			AssetFileDescriptor afd = am.openFd("shot.mp3");
			mediaPlayer2 = new MediaPlayer();
			// 使用MediaPlayer加载指定的声音文件。
			mediaPlayer2.setDataSource(afd.getFileDescriptor());
			mediaPlayer2.prepare();		
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(getResources().getAssets().open("haode.txt"));
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line = "";
			
			while ((line = bufferedReader.readLine())!=null) {
				result+=line+"\n";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		// 获取第一个按钮，并为它绑定事件监听器
		Button playRaw = (Button) findViewById(R.id.playRaw);
		playRaw.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				// 播放声音
				mediaPlayer1.start();
			}
		});
		// 获取第二个按钮，并为它绑定事件监听器
		Button playAsset = (Button) findViewById(R.id.playAsset);
		playAsset.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				// 播放声音
				mediaPlayer2.start();
			}
		});
		Button myStyle = (Button)findViewById(R.id.playMe);
		myStyle.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
			Toast.makeText(RawResTest.this, result	, Toast.LENGTH_SHORT).show();
			}
		});
	}
}










