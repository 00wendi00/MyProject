package hainu.it.regist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class ClientThread implements Runnable
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
					String str = null;
					try {
						while((str = br.readLine().toString()).equals("success"))  
						{
							//Log.d(null, "---------------------????----------------------");
							Message msg = new Message();
							msg.what = 0x123;
							msg.obj = "0";
							handler.sendMessage(msg);
						}
						while((str = br.readLine().toString()).equals("failure"))
						{
							Message msg = new Message();
							msg.what = 0x123;
							msg.obj = "1";
							handler.sendMessage(msg);
						}
					} catch (IOException e) {
						e.printStackTrace();
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
							os.write((msg.obj+"\r\n").getBytes("utf-8"));
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
