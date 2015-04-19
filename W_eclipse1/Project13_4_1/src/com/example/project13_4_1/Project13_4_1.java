package com.example.project13_4_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Project13_4_1 extends Activity {
	EditText url;
	WebView show;
	Button button;
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project13_4_1);
		url = (EditText)findViewById(R.id.url);
		show = (WebView)findViewById(R.id.show);
		show.getSettings().setJavaScriptEnabled(true);
		show.setActivated(true);
		button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				String urlStr = url.getText().toString();
				show.loadUrl(urlStr);
			}
		});
	}
}
