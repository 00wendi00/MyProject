package com.example.project13_4_3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
public class Project13_4_3 extends Activity
{
	WebView myWebView;
	@SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		myWebView = (WebView)findViewById(R.id.show);
		myWebView.loadUrl("file:///android_asset/test.html");
		myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.addJavascriptInterface( new MyObject(this), "myObj");
	}
}
