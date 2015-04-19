package com.example.project15_2_1;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Project15_2_1 extends Activity {
	private SensorManager mSensorManager;
	private Sensor accelerometer; // 加速度传感器
	private Sensor magnetic; // 地磁场传感器
	private TextView azimuthAngle;
	private float[] accelerometerValues = new float[3];
	private float[] magneticFieldValues = new float[3];
	private static final String TAG = "---MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project15_2_1);
		// 实例化传感器管理者
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		// 初始化加速度传感器
		accelerometer = mSensorManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		// 初始化地磁场传感器
		magnetic = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		azimuthAngle = (TextView) findViewById(R.id.text);
		calculateOrientation();
	}
	@Override
	protected void onResume() 
	{
		// TODO Auto-generated method stub
		// 注册监听
		mSensorManager.registerListener(new MySensorEventListener(),
				accelerometer, Sensor.TYPE_ACCELEROMETER);
		mSensorManager.registerListener(new MySensorEventListener(), 
				magnetic,Sensor.TYPE_MAGNETIC_FIELD);
		super.onResume();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		// 解除注册
		mSensorManager.unregisterListener(new MySensorEventListener());
		super.onPause();
	}
	// 计算方向
	private void calculateOrientation() 
	{
		float[] values = new float[3];
		float[] R = new float[9];
		SensorManager.getRotationMatrix(R, null, accelerometerValues,magneticFieldValues);
		SensorManager.getOrientation(R, values);
		values[0] = (float) Math.toDegrees(values[0]);
		Log.i(TAG, values[0] + "");   // ................................
		if (values[0] >= -5 && values[0] < 5) {
			azimuthAngle.setText("正北");
		} else if (values[0] >= 5 && values[0] < 85) {
			// Log.i(TAG, "东北");
			azimuthAngle.setText("东北");
		} else if (values[0] >= 85 && values[0] <= 95) {
			// Log.i(TAG, "正东");
			azimuthAngle.setText("正东");
		} else if (values[0] >= 95 && values[0] < 175) {
			// Log.i(TAG, "东南");
			azimuthAngle.setText("东南");
		} else if ((values[0] >= 175 && values[0] <= 180)
				|| (values[0]) >= -180 && values[0] < -175) {
			// Log.i(TAG, "正南");
			azimuthAngle.setText("正南");
		} else if (values[0] >= -175 && values[0] < -95) {
			// Log.i(TAG, "西南");
			azimuthAngle.setText("西南");
		} else if (values[0] >= -95 && values[0] < -85) {
			// Log.i(TAG, "正西");
			azimuthAngle.setText("正西");
		} else if (values[0] >= -85 && values[0] < -5) {
			// Log.i(TAG, "西北");
			azimuthAngle.setText("西北");
		}
	}
	class MySensorEventListener implements SensorEventListener {
		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
				accelerometerValues = event.values;
			}
			if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
				magneticFieldValues = event.values;
			}
			calculateOrientation();
		}
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
		}
	}
}
