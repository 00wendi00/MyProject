package com.example.project16_4;

import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;

public class Project16_4 extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project16_4);
		String locService = Context.LOCATION_SERVICE;
		LocationManager locationManager;
		locationManager = (LocationManager)getSystemService(locService);
		double longitude = 110.33;
		double latitude = 20.06;
		float radius = 5000 ;   //  æ‡¿Î   /m  µ•Œª
		Intent intent = new Intent(this, ProximityAlertReciever.class);
		PendingIntent pi = PendingIntent.getBroadcast(this, -1, intent, 0);
		locationManager.addProximityAlert(latitude, longitude, radius, -1, pi);
	}
}
