package com.example.music.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

/**
 *向服务器发送请求
 */
public class HttpUtil {
	
	public static void sendHttpRequest(final String address,final HttpCallbackListener listener){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				HttpURLConnection connection = null;
				try {
					URL url = new URL(address);
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(5000);
					connection.setReadTimeout(5000);
					connection.getResponseCode();
					Log.e("HttpUtil", String.valueOf(connection.getResponseCode()));
					InputStream in = connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					while((line=reader.readLine())!=null){
						response.append(line);
					}
					if (listener!=null){
						listener.onFinish(response.toString());
					}
				} catch (Exception e) {
					if (listener!=null){
						listener.onError(e);
					}
				}finally{
					if(connection!=null){
						connection.disconnect();
					}
				}
			}
		}).start();
	}

}
