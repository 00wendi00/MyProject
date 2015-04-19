package org.crazyit.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Description:
 * <br/>site: <a href="http://www.crazyit.org">crazyit.org</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class SDFileExplorer extends Activity
{
	ListView listView;
	TextView textView;
	File currentParent;
	File[] currentFiles;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// ��ȡ�г�ȫ���ļ���ListView
		listView = (ListView) findViewById(R.id.list);
		textView = (TextView) findViewById(R.id.path);
		// ��ȡϵͳ��SD����Ŀ¼
		File root = new File("/mnt/sdcard/");
		// ��� SD������
		if (root.exists())
		{
			currentParent = root;
			currentFiles = root.listFiles();
			// ʹ�õ�ǰĿ¼�µ�ȫ���ļ����ļ��������ListView
			inflateListView(currentFiles);
		}
		// ΪListView���б���ĵ����¼��󶨼�����
		listView.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
				int position, long id)
			{
				// �û��������ļ���ֱ�ӷ��أ������κδ���
				if (currentFiles[position].isFile()) return;
				// ��ȡ�û�������ļ����µ������ļ�
				File[] tmp = currentFiles[position].listFiles();
				if (tmp == null || tmp.length == 0)
				{
					Toast.makeText(SDFileExplorer.this
						, "��ǰ·�����ɷ��ʻ��·����û���ļ�",
						Toast.LENGTH_SHORT).show();
				}
				else
				{
					// ��ȡ�û��������б����Ӧ���ļ��У���Ϊ��ǰ�ĸ��ļ���
					currentParent = currentFiles[position]; //��
					// ���浱ǰ�ĸ��ļ����ڵ�ȫ���ļ����ļ���
					currentFiles = tmp;
					// �ٴθ���ListView
					inflateListView(currentFiles);
				}
			}
		});
		// ��ȡ��һ��Ŀ¼�İ�ť
		Button parent = (Button) findViewById(R.id.parent);
		parent.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				try
				{
					if (!currentParent.getCanonicalPath()
						.equals("/mnt/sdcard"))
					{
						// ��ȡ��һ��Ŀ¼
						currentParent = currentParent.getParentFile();
						// �г���ǰĿ¼�������ļ�
						currentFiles = currentParent.listFiles();
						// �ٴθ���ListView
						inflateListView(currentFiles);
					}
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	private void inflateListView(File[] files) //��
	{
		// ����һ��List���ϣ�List���ϵ�Ԫ����Map
		List<Map<String, Object>> listItems = 
			new ArrayList<Map<String, Object>>();
		for (int i = 0; i < files.length; i++)
		{
			Map<String, Object> listItem = 
				new HashMap<String, Object>();
			// ���ǰFile���ļ��У�ʹ��folderͼ�ꣻ����ʹ��fileͼ��
			if (files[i].isDirectory())
			{
				listItem.put("icon", R.drawable.folder);
			}
			else
			{
				listItem.put("icon", R.drawable.file);
			}
			listItem.put("fileName", files[i].getName());
			// ���List��
			listItems.add(listItem);
		}
		// ����һ��SimpleAdapter
		SimpleAdapter simpleAdapter = new SimpleAdapter(this
			, listItems, R.layout.line
			, new String[]{ "icon", "fileName" }
			, new int[]{R.id.icon, R.id.file_name });
		// ΪListView����Adapter
		listView.setAdapter(simpleAdapter);
		try
		{
			textView.setText("��ǰ·��Ϊ��" 
				+ currentParent.getCanonicalPath());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}