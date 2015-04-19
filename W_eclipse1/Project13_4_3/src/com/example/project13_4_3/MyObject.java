package com.example.project13_4_3;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

public class MyObject
{
	Context mContext;

	MyObject(Context c)
	{
		mContext = c;
	}
	// �÷������ᱩ¶��JavaScript�ű�����
	public void showToast(String name)
	{
		Toast.makeText(mContext, name + "����ã�"
			, Toast.LENGTH_LONG).show();
	}
	// �÷������ᱩ¶��JavaScript�ű�����
	public void showList()
	{
		// ��ʾһ����ͨ���б�Ի���
		new AlertDialog.Builder(mContext)
			.setTitle("ͼ���б�")
			.setIcon(R.drawable.ic_launcher)
			.setItems(new String[]{"���Java����"
			, "���Android����" , "������Java EE��ҵӦ��ʵս"} , null)
			.setPositiveButton("ȷ��", null)
			.create()
			.show();
	}
}
