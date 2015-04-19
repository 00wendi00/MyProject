package hainu.it.login;

import java.util.Timer;
import java.util.TimerTask;
import hainu.it.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class LoginInterfacePre extends Activity
{
	TextView textView ;
	int progess = 0;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams.TYPE_STATUS_BAR, WindowManager.LayoutParams.TYPE_STATUS_BAR); 
		setContentView(R.layout.loginframepre);
		textView = (TextView)findViewById(R.id.textView1);
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run()
			{
				Message msg = new Message();
				msg.what = 0x123;
				if(progess>=100)
				{
					timer.cancel();
					Intent intent = new Intent(LoginInterfacePre.this, LoginInterface.class);
					startActivity(intent);
					finish();
				}
				else
				{
					handler.sendMessage(msg);
				}
			}
		}, 0, 20);
	}
	@SuppressLint("HandlerLeak")
	Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(msg.what==0x123)
			{			
				progess++;
				textView.setText("已加载 : "+progess+"%");
			}
		}
	};
}
