package com.example.project7_1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Project7_1_2 extends Activity {
	TextView text;
	String  s;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project7_1_2);
		text = (TextView)findViewById(R.id.text);
		
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(getResources()
					.openRawResource(R.raw.abcd));  //×Ö½Ú--×Ö·ûµÄ ÇÅÁº~~
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line = "";
			String result = "";
			while((line = bufferedReader.readLine())!=null)
				result += line+"\n";
			s  = result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		try {
			InputStreamReader inputStreamReader =  new InputStreamReader(getResources()
					.getAssets().open("abc.txt"));
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line = "";
			String result = "";
			while((line = bufferedReader.readLine())!= null)
				result += line+"\n";
			s += result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		text.setText(s);
	}
}
