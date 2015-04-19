package org.crazyit.intentProject5_2_4;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

/**
 * Description:
 * <br/>website: <a href="http://www.crazyit.org">crazyit.org</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class SchemeHostPathActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		tv.setText("ָ��Scheme��Host��Pathƥ���Activity");
		tv.setTextSize(30);
		setContentView(tv);
	}
}
