package org.crazyit.actionProject5_2_3;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Description: <br/>
 * site: <a href="http://www.crazyit.org">crazyit.org</a> <br/>
 * Copyright (C), 2001-2012, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class SysAction extends Activity
{
	final int PICK_CONTACT = 0;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button bn = (Button) findViewById(R.id.bn);
		// Ϊbn��ť���¼�������
		bn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				// ����Intent
				Intent intent = new Intent();
				//����Intent��Action����
				intent.setAction(Intent.ACTION_GET_CONTENT);
				//����Intent��Type����
				intent.setType("vnd.android.cursor.item/phone");
				// ����Activity����ϣ����ȡ��Activity�Ľ��
				startActivityForResult(intent, PICK_CONTACT);
			}
		});
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode)
		{
			case(PICK_CONTACT):
				if(resultCode == Activity.RESULT_OK){
					Uri cantactData = data.getData();
					CursorLoader cursorLoader = new CursorLoader(this, cantactData, null, null, null, null);
					Cursor cursor = cursorLoader.loadInBackground();
					if(cursor.moveToFirst()){
						//  ���ContactsContract....�漰����Provider
						String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
						String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
						String phoNumber = "�����ϵ����ʱû���������";
						//������ϵ�˲鿴��ϵ�˵������Ϣ.
						Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI
								, null
								, ContactsContract.CommonDataKinds.Phone._ID + " = " +contactId
								, null
								, null);
						if(phones.moveToFirst()){
							phoNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
							phones.close();
							EditText show = (EditText)findViewById(R.id.show);
							show.setText(name);
							EditText phone  = (EditText)findViewById(R.id.phone);
							phone.setText(phoNumber);
						}
						cursor.close(); 
					}
					break;
				}
		}
	}
}










