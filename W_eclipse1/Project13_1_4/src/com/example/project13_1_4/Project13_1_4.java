package com.example.project13_1_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Project13_1_4 extends Activity 
{
	EditText input;
	TextView show;
	Button send;
	Handler handler;
	ClientThread clientThread;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project13_1_4);
		input = (EditText)findViewById(R.id.input);
		send = (Button)findViewById(R.id.send);
		show = (TextView)findViewById(R.id.show);
		handler = new Handler()
		{
			public void handleMessage(Message msg)
			{
				if(msg.what == 0x123)
				{
					show.append("\n"+msg.obj.toString());
				}
			}
		};
		clientThread = new ClientThread(handler);
		new Thread(clientThread).start();
		send.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				try {
					Message msg = new Message();
					msg.what = 0x345;
					msg.obj = input.getText().toString();
					clientThread.revHandler.sendMessage(msg);
					input.setText("");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
class ClientThread implements Runnable
{
	private Socket s ;
	private Handler handler;
	public Handler revHandler;
	BufferedReader br = null;
	OutputStream os = null;
	public ClientThread(Handler handler)
	{
		this.handler = handler;
	}
	public void run()
	{
		try {
			s = new Socket("172.16.21.85",30000);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			os = s.getOutputStream();
			new Thread()
			{
				public void run()
				{
					String content = null;
					try {
						while((content = br.readLine())  != null)
						{
							Message msg = new Message();
							msg.what = 0x123;
							msg.obj = content;
							handler.sendMessage(msg);
						}
					} catch (IOException e) {
						// TODO: handle exception
					}
				}
			}.start();
			
			Looper.prepare();
			
			revHandler = new Handler()
			{
				public void handleMessage(Message msg)
				{
					if(msg.what == 0x345)
					{
						try {
							os.write((msg.obj.toString()+"\r\n").getBytes());
						} catch (Exception e) {
								e.printStackTrace();
						}
					}
				}
			};
			Looper.loop();	
		} catch (SocketTimeoutException e) {
			System.out.println("网络连接超时");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
