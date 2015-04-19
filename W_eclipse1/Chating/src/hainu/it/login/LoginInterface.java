package hainu.it.login;

import hainu.it.R;
import hainu.it.chating.Chating;
import hainu.it.regist.Registration;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginInterface extends Activity
{
	public static Activity activityLogin;  // 这里要用　public 
	Database_Account db_Account;
	Cursor cursor1;
	AutoCompleteTextView accountText;
	EditText passwdText;
	Button saveBt;
	TextView textView;
	String[][] havedAccountPasswd;
	String[] havedAccount;
	public void onCreate(Bundle savedInstanceState)
	{
		activityLogin = this;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.logininterface);
		db_Account = new Database_Account(this, "pre_account.db3", 1);
		final SQLiteDatabase db = db_Account.getWritableDatabase();
		accountText = (AutoCompleteTextView)findViewById(R.id.account);
		passwdText = (EditText)findViewById(R.id.password);
		saveBt = (Button)findViewById(R.id.loginButton);	
		textView = (TextView)findViewById(R.id.regist);
		textView.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View v)
			{
				Intent intent = new Intent(LoginInterface.this, Registration.class);
				startActivity(intent); 
			}
		});
		
		//将保存的账户数据库   设置为自动完成文本框的下拉框   ++  上次登录成功的 账户密码~~
		cursor1 = db.rawQuery("select * from dict", null);
		cursor1.moveToFirst();
		havedAccountPasswd = new String[cursor1.getCount()][2];
		havedAccount = new String[cursor1.getCount()];
		for(int i =0;i<cursor1.getCount();i++)
		{
			havedAccount[i] = cursor1.getString(1);
			havedAccountPasswd[i][0] = cursor1.getString(1);
			havedAccountPasswd[i][1] = cursor1.getString(2);
			if(i != cursor1.getCount()-1)
				cursor1.moveToNext();
		}
		//冒泡排序　法,对自动完成文本的　droptext数据进行排序
		String temp1[] = {"",""};
		String temp2 = "";
		int length = cursor1.getCount();
		if( length >1)
		{
			for(int i = 0;i<length; i++)
			{
				for(int k = i;k<length;k++)
				{
					if (Double.parseDouble(havedAccountPasswd[i][0])<Double.parseDouble(havedAccountPasswd[k][0]))
					{
						temp1 = havedAccountPasswd[i]; 
						havedAccountPasswd[i] = havedAccountPasswd[k];
						havedAccountPasswd[k] = temp1;
						
						temp2 = havedAccount[i];
						havedAccount[i] = havedAccount[k];
						havedAccount[k] = temp2;
					}
				}
			}
		}
		
		if(cursor1.getCount()>0)
		{
			String accountAuto = cursor1.getString(1);
			accountText.setText(accountAuto);
			passwdText.setText(cursor1.getString(2));
		}
		accountText.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View view,int position, long id)
			{
				//passwdText.setText(havedAccountPasswd[cursor1.getCount()-accountText.getdro+position][1]);
				String s = accountText.getText().toString();
				for(int i = 0 ;i<cursor1.getCount();i++)
				{
					if(s.equals(havedAccount[i]) )
					{
						passwdText.setText(havedAccountPasswd[i][1]);
					}
				}
			}
		});
		
		
		ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, R.layout.dropdown_list,havedAccount);
		accountText.setAdapter(adapter);
		
		/*if (cursor.getCount() > 0) 
        { 
            //  必须使用moveToFirst方法将记录指针移动到第1条记录的位置 
            cursor.moveToFirst(); 
            result = cursor.getString(cursor.getColumnIndex("chinese")); 
            Log.i("tran", "success"+result); 
        } 
        //  显示查询结果对话框 
        new AlertDialog.Builder(this).setTitle("查询结果").setMessage(result) 
                .setPositiveButton("关闭", null).show();*/
		
		
		saveBt.setOnClickListener(new Button.OnClickListener() 
		{
			@SuppressLint("ShowToast")
			public void onClick(View v) 
			{
				String account = accountText.getText().toString();
				String passwd = passwdText.getText().toString();
				if(account.length()<5)
				{
					new AlertDialog.Builder(LoginInterface.this)
						.setTitle("温馨提示!")
						.setMessage("请输入５位数及以上的数字")
						.setNegativeButton("确定", null)
						.show();
					return ;
				}		
				if(passwd.length()<6)
				{
					new AlertDialog.Builder(LoginInterface.this)
						.setTitle("温馨提示!")
						.setMessage("请输入６位及以上的密码")
						.setNegativeButton("确定", null)
						.show();
					return;
				}
				
				//这里就联网看账号密码，是否正确
				
				insertData(db_Account.getReadableDatabase(), account, passwd);   // 这个方法里面自然有判定
				Toast.makeText(LoginInterface.this, "登陆成功", 8000).show();							
				Intent intent = new Intent(LoginInterface.this,Chating.class);
				startActivity(intent);
				finish();
			}
		});
	}
	/*protected ArrayList<Map<String, String>> converCursorToList(Cursor cursor)
	{
		ArrayList<Map<String, String>> result = new ArrayList<Map<String,String>>();
		while(cursor.moveToNext())
		{
			Map<String, String> map = new HashMap<String, String>();
			map.put("account", cursor.getString(1));
			map.put("passwd", cursor.getString(2));
			result.add(map);
		}
		return result;
	}*/
	
	//　如果account一样  passwd不一样，则跟新。若一样，则不新
	private void insertData(SQLiteDatabase db,String account,String passwd)
	{
		boolean flags = true;
		for(int i = 0;i<havedAccountPasswd.length;i++)
		{
			if(havedAccountPasswd[i][0].equals(account))
			{
				flags = false;
				if(!havedAccountPasswd[i][1].equals(passwd))
				{					
					//数据库的跟新！！！！
					db.execSQL("update dict set passwd=? where account=?",new String[]{passwd ,havedAccountPasswd[i][0]});
				}
			}
		}
		if(flags)
			db.execSQL("insert into dict values(null,?,?)",new String[]{account,passwd});
	}
	public void onDestroy()
	{
		super.onDestroy();
		if(db_Account != null)
		{
			db_Account.close();
		}
	}
}
