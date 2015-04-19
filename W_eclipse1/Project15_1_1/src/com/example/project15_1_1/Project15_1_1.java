package com.example.project15_1_1;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class Project15_1_1 extends Activity implements SensorEventListener
{
	SensorManager sensorManager;
	EditText edit1,edit2,edit3,edit4,edit5,edit6;
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project15_1_1);
		edit1 = (EditText)findViewById(R.id.text1);
		edit2  =(EditText)findViewById(R.id.text2);
		edit3  =(EditText)findViewById(R.id.text3);
		edit4  =(EditText)findViewById(R.id.text4);
		edit5 =(EditText)findViewById(R.id.text5);
		edit6 =(EditText)findViewById(R.id.text6);
		sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
	}
	@SuppressWarnings("deprecation")
	protected void onResume()
	{
		super.onResume();
		float[] values = new float[3];
		float[] R = new float[9];
		SensorManager.getOrientation(R, values);
		values[0] = (float) Math.toDegrees(values[0]);
		sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
					SensorManager.SENSOR_DELAY_UI);  
		sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
					sensorManager.SENSOR_DELAY_UI);

		sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), 
					sensorManager.SENSOR_DELAY_UI);
		sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
					SensorManager.SENSOR_DELAY_UI);
		sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT), 
					SensorManager.SENSOR_DELAY_UI);
		sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE), 
					sensorManager.SENSOR_DELAY_UI);
	}
	protected void onStop()
	{
		sensorManager.unregisterListener(this);
		super.onStop();
	}
	protected void onPause()
	{
		sensorManager.unregisterListener(this);
		super.onPause();
	}
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		
	}
	@SuppressWarnings("deprecation")
	public void onSensorChanged(SensorEvent event) {
		float[] values  = event.values;
		int sensorType = event.sensor.getType();	 // 判断传感器类型
		StringBuilder sb = null;
		switch(sensorType)
		{
			case Sensor.TYPE_ACCELEROMETER:
				sb =new StringBuilder();
				sb.append("X方向的加速度 : "+values[0]);
				sb.append("\nY方向的加速度 : "+values[1]);
				sb.append("\nZ方向的加速度 : "+values[2]);
				edit1.setText(sb.toString());
				break;
			case Sensor.TYPE_ORIENTATION:
				sb =new StringBuilder();
				sb.append("绕Z轴转过的角度 : "+values[0]);
				sb.append("\n绕X轴转过的角度 : "+values[1]);
				sb.append("\n绕Y轴转过的角度 : "+values[2]);
				edit2.setText(sb.toString());
				break;
			case Sensor.TYPE_MAGNETIC_FIELD:
				sb =new StringBuilder();
				sb.append("X方向上的角度 : "+values[0]);
				sb.append("\nY方向上的角度 : "+values[1]);
				sb.append("\nZ方向上的角度 : "+values[2]);
				edit3.setText(sb.toString());
				break;
			case Sensor.TYPE_AMBIENT_TEMPERATURE:
				sb =new StringBuilder();
				sb.append("当前温度 : "+values[0]);
				edit4.setText(sb.toString());
				break;
			case Sensor.TYPE_LIGHT:
				sb =new StringBuilder();
				sb.append("当前光强: "+values[0]);
				edit5.setText(sb.toString());
				break;
			case Sensor.TYPE_PRESSURE:
				sb =new StringBuilder();
				sb.append("当前压力为 : "+values[0]);
				edit6.setText(sb.toString());
				break;
		}
	}
}
