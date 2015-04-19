package com.example.project16_3;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.EditText;

public class Project16_3 extends Activity {
	 LocationManager locManager;
	 EditText show;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project16_3);
		show = (EditText)findViewById(R.id.etxt);
		locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		Location location = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		updateView(location);
		
		locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 8, new LocationListener() {
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				updateView(locManager.getLastKnownLocation(provider));
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				updateView(null);
			}
			
			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				updateView(location);
			}
		});
	}
	public void updateView(Location newLocation){
		if (newLocation  != null) {
			StringBuilder sb = new StringBuilder();
			sb.append("ʵʱ��λ����Ϣ:\n");
			sb.append("����");
			sb.append(newLocation.getLongitude());
			sb.append("\nά��");
			sb.append(newLocation.getLatitude());
			sb.append("\n�߶�");
			sb.append(newLocation.getAltitude());
			sb.append("\n�ٶ�");
			sb.append(newLocation.getSpeed());
			sb.append("\n����");
			sb.append(newLocation.getBearing());
			show.setText(sb.toString());
		}
		else {
			show.setText("gps ��λ�����ð�~~");
		}
	}
}
