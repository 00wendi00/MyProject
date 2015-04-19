package hainu.it.chating;

import hainu.it.R;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;

public class Chating extends FragmentActivity
{
	private TabHost tabHost;
	TextView top_text1;
	TextView top_text2;
	TabWidget mTabWidget;
	@SuppressLint("InflateParams")
	protected void onCreate(Bundle arg0) 
	{
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		this.setContentView(R.layout.activity_main);
		//getActionBar().hide();
		top_text1 = (TextView)findViewById(R.id.top_text1);
		top_text2 = (TextView)findViewById(R.id.top_text2);
		final View resultDialog = getLayoutInflater().inflate(R.layout.result, null);
			
		View guideWeiTao = (View) LayoutInflater.from(this).inflate(
				R.layout.guide_weitao, null);
		View guideAccount = (View) LayoutInflater.from(this).inflate(
				R.layout.guide_account, null);
		View guideLife = (View) LayoutInflater.from(this).inflate(
				R.layout.guide_nearby, null);
		
		// 获取tabHost,tabHost是个容器组件
				tabHost = (TabHost) findViewById(R.id.tabhost);
				// Call setup() before adding tabs if loading TabHost using
				// findViewById() except TabActivity
				tabHost.setup(); // 类似于初始化过程，不调用无法获取到tabWiget,调用addTab需要tabwiget。TabActivity内部已经调用了

				TabSpec mTabSpec1 = tabHost.newTabSpec("tab1").setIndicator(guideWeiTao).setContent(R.id.content1);
				TabSpec mTabSpec2 = tabHost.newTabSpec("tab2").setIndicator(guideAccount).setContent(R.id.ac_list);
				TabSpec mTabSpec3= tabHost.newTabSpec("tab3").setIndicator(guideLife).setContent(R.id.content3);
				
				tabHost.addTab(mTabSpec1);
				tabHost.addTab(mTabSpec2);
				tabHost.addTab(mTabSpec3);
				mTabWidget = tabHost.getTabWidget();
				// tabHost.getTabWidget();   这一步很重要，没有上一步，必须这一步
			 	
				tabHost.setOnTabChangedListener(new OnTabChangeListener() 
				{
					public void onTabChanged(String tabId) 
					{
						if(tabId.equals("tab1"))
						{
							top_text1.setText("Chating");
							top_text2.setText("设置");
						}
						else if(tabId.equals("tab2"))
						{
							top_text1.setText("联系人");
							top_text2.setText("添加");
						}
						else 
						{
							top_text1.setText("好友动态");
							top_text2.setText("~~");
						}
					}
				});
					
		ExpandableListAdapter adapter2 = new BaseExpandableListAdapter() {
			private TextView getTextViewChild()
			{
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,100);
				TextView textView = new TextView(Chating.this);
				textView.setLayoutParams(lp);
				textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
				textView.setPadding(80, 50, 0, 0);
				return textView;
			}
			private TextView getTextViewFather()
			{
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,100);
				TextView textView = new TextView(Chating.this);
				textView.setLayoutParams(lp);
				textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
				textView.setPadding(80, 50, 0, 0);
				textView.setTextSize(30);
				return textView;
			}
			public boolean isChildSelectable(int groupPosition, int childPosition) {
				return true;
			}
			public boolean hasStableIds() {
				return true;
			}
			public View getGroupView(int groupPosition, boolean isExpanded,View convertView, ViewGroup parent) {
				LinearLayout ll = new LinearLayout(Chating.this);
				ll.setOrientation(0);
				TextView textView = getTextViewFather();
				textView.setText("好吧");
				ll.addView(textView);
				return ll;
			}
			public long getGroupId(int groupPosition) {
				return groupPosition;
			}
			public int getGroupCount() {
				return 5;   //  这里注意~~~~~~~~~~
			}
			public Object getGroup(int groupPosition) {
				return "第几个人";
			}
			public int getChildrenCount(int groupPosition) {
				return 1;
			}
			public View getChildView(int groupPosition, int childPosition,boolean isLastChild, View convertView, ViewGroup parent)
			{
				TextView textView = getTextViewChild();
				textView.setText("child");
				return textView;
			}
			public long getChildId(int groupPosition, int childPosition) {
				return childPosition;
			}
			public Object getChild(int groupPosition, int childPosition) {
				return "好吧";
			}
		};
		ExpandableListView listView = (ExpandableListView)findViewById(R.id.ac_list);
		listView.setGroupIndicator(null);   // 去掉 listfather 左边的小勾勾
		listView.setAdapter(adapter2);
		
		//　这个到底为什么？
		top_text2.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) 
			{
				if(top_text2.getText().toString().equals("设置"))
					new AlertDialog.Builder(Chating.this).setView(resultDialog).setTitle("这个对话框退出再点就停止了").setPositiveButton("确定", null).show();
				else {
					return;
				}
			}
		});
		
		//Intent intent = new Intent(Chating.this,Chating.class);
		
	}
}
