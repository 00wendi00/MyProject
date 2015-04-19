package hainu.it.regist;

import hainu.it.R;
import hainu.it.chating.Chating;
import hainu.it.login.LoginInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends Activity
{
	TextView top_return_text;
	EditText edit1,edit2,edit3,edit4,edit5;
	Button button;
	RadioGroup rg;
	String sex = "male";
	Handler handler;
	ClientThread clientThread;
	@SuppressLint("HandlerLeak")
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		top_return_text = (TextView)findViewById(R.id.top_return);
		edit1 = (EditText)findViewById(R.id.edit1);
		edit2 = (EditText)findViewById(R.id.edit2);
		edit3 = (EditText)findViewById(R.id.edit3);
		edit4 = (EditText)findViewById(R.id.edit4);
		edit5 = (EditText)findViewById(R.id.edit5);
		rg = (RadioGroup)findViewById(R.id.rg);
		button = (Button)findViewById(R.id.regist_button);
		
		top_return_text.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				Intent intent = new Intent(Registration.this, LoginInterface.class);
				startActivity(intent);
				finish();
			}
		});
		
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) 
			{
				if(checkedId == R.id.male)
				{
					sex = "male";
				}
				else if (checkedId == R.id.female) {
					sex = "female";
				}
				else {
					sex = "other";
				}
			}
		});
		
		handler = new Handler()
		{
			public void handleMessage(Message msg)
			{
				if(msg.what == 0x123)
				{
					Toast.makeText(Registration.this, "提交成功", Toast.LENGTH_SHORT).show();
					if(msg.obj.equals("0")){
						//注册成功！！
						Toast.makeText(Registration.this, "注册成功", Toast.LENGTH_SHORT).show();
						new AlertDialog.Builder(Registration.this)
							.setTitle("注册成功:"+"\n")
							.setMessage("您的账号为:"+edit1.getText().toString()+"\n"+"您的密码为:"+edit2.getText().toString()+"\n"+"您的性别为:"+sex)
							//这一步要注意
							.setPositiveButton("确定", new DialogInterface.OnClickListener() 
							{
								public void onClick(DialogInterface dialog, int which) {
									Intent intent = new Intent(Registration.this,Chating.class);
									startActivity(intent);
									finish();
									LoginInterface.activityLogin.finish();
								}
							}).show();
					}
					else  if(msg.obj.equals("1"))
					{
						//注册失败了
						//Toast.makeText(Registration.this, "注册失败", Toast.LENGTH_SHORT).show();
						new AlertDialog.Builder(Registration.this).setTitle("此账号已经被注册,请换填注册账号!!!").setPositiveButton("确定", null).show();
					}
					else {
						new AlertDialog.Builder(Registration.this).setTitle("出现未知错误,请重试!!!").setPositiveButton("确定", null).show();
					}
				}
			}
		};
		clientThread = new ClientThread(handler);
		new Thread(clientThread).start();	
		
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) 
			{
				if(edit1.getText().length()<6||edit2.getText().length()<3)
				{
					new AlertDialog.Builder(Registration.this).setTitle("请输入6位以上的账号,3位以上密码").setPositiveButton("确定", null).show();
					return;
				}
				Pattern pattern = Pattern.compile("[0-9]*");
				Matcher isNum = pattern.matcher(edit1.getText().toString());
				if (!isNum.matches()) 
				{
					new AlertDialog.Builder(Registration.this).setTitle("账号全部位数字,请重新输入").setPositiveButton("确定", null).show();
					return;
				}
				if(!edit2.getText().toString().equals(edit3.getText().toString()))
				{
					new AlertDialog.Builder(Registration.this).setTitle("两次输入的密码不同").setPositiveButton("确定", null).show();
					return;
				}
				
				String obj = edit1.getText().toString()+"\n"+edit2.getText().toString()+"\n"+sex;
				
				try {
					Message msg = new Message();
					msg.what = 0x345;
					msg.obj = obj;
					clientThread.revHandler.sendMessage(msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
}
