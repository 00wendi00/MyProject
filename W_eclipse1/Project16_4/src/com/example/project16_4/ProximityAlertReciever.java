package com.example.project16_4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.widget.Toast;

public class ProximityAlertReciever extends BroadcastReceiver{

	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		boolean isEnter = intent.getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING, false);
		if(isEnter){
			Toast.makeText(context, "我尼玛 就在宿舍，宿舍狗", Toast.LENGTH_SHORT).show();
		}
		else {
			Toast.makeText(context, "不在宿舍", Toast.LENGTH_SHORT).show();
		}
	}
}
