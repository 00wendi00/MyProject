package com.example.project16_1;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Project16_1 extends Activity {
	ListView providers;
	LocationManager lm;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project16_1);
		providers = (ListView) findViewById(R.id.providers);
		// 获取系统的LocationManager对象
		lm = (LocationManager)getSystemService(
			Context.LOCATION_SERVICE);
		// 获取系统所有的LocationProvider的名称
		List<String> providerNames = lm.getAllProviders();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
			this,
			android.R.layout.simple_list_item_1,
			providerNames);
		// 使用ListView来显示所有可用的LocationProvider
		providers.setAdapter(adapter);
	}
}
