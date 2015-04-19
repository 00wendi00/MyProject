package com.example.project13_2_1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class Project13_2_1 extends Activity 
{
	ImageView show;
	Bitmap bitmap;
	Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(msg.what ==0x123)
			{
				show.setImageBitmap(bitmap);
			}
		}
	};
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		show = (ImageView)findViewById(R.id.show);
		new Thread()
		{
			public void run()
			{
				try {
					URL url = new URL("http://www.crazyit.org/"+"attachments/month_1008/20100812_7763e970f"+"822325bfb019ELQVym8tW3A.png");
					InputStream is = url.openStream();
					bitmap = BitmapFactory.decodeStream(is);
					handler.sendEmptyMessage(0x123);
					is.close();
					
					is = url.openStream();
					OutputStream os = openFileOutput("crazyit.png", MODE_WORLD_READABLE);
					byte[] buff = new byte[1024];
					int hasRead = 0;
					while((hasRead  = is.read(buff))>0)
					{
						os.write(buff,0,hasRead);
					}
					is.close();
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
