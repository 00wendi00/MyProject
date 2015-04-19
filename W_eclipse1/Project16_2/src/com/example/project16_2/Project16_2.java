package com.example.project16_2;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Project16_2 extends Activity {
	ListView providers;
	LocationManager lm;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project16_2);
		providers = (ListView)findViewById(R.id.providers);
		lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		Criteria cri = new Criteria();
		cri.setCostAllowed(false);
		cri.setAltitudeRequired(true);
		cri.setBearingRequired(true);
		List<String> providerNames = lm.getProviders(cri, false);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,providerNames);
		providers.setAdapter(adapter);
	}
}
