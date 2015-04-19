package com.example.project7_1_1;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.AssetManager.AssetInputStream;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class Project7_1_1 extends Activity {

	//Bitmap��BitmapFactory�ļ�������~~ʵ�� ��ȡ AssetͼƬ��Դ
	AssetManager assets = null;
	String[] images = null;
	ImageView image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project7_1_1);
		image = (ImageView)findViewById(R.id.image);	
		try {
			assets = getAssets();
			images = assets.list("");  //��ȡ /assets�е������ļ�~
		} catch (IOException e) {
			// TODO: handle exception
		}
		InputStream assetFile = null;
		try {
			assetFile = assets.open(images[1]);
		} catch (IOException e) {
			// TODO: handle exception
		}
		image.setImageBitmap(BitmapFactory.decodeStream(assetFile));
																	//2.decodeByteArray...3.decodeFile...4.decodeResource...
	}
}