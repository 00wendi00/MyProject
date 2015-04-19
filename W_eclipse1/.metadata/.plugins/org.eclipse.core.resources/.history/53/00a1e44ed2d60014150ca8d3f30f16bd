package com.swipe.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;

public class MainActivity extends Activity {

	private SwipeListView mSwipeListView;
	private SwipeListViewAdapter adapter;
	private List<TestData> datas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		mSwipeListView=(SwipeListView) findViewById(R.id.example_lv_list);
		mSwipeListView.setOffsetLeft(this.getResources().getDisplayMetrics().widthPixels*2/3);
//		mSwipeListView.setSwipeMode(SwipeListView.SWIPE_MODE_LEFT);
//		mSwipeListView.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL);
//		mSwipeListView.setAnimationTime(0);
//		mSwipeListView.setSwipeOpenOnLongPress(false);
		initDatas();
		adapter=new SwipeListViewAdapter(this, mSwipeListView, datas);
		mSwipeListView.setAdapter(adapter);
		mSwipeListView.setSwipeListViewListener(new BaseSwipeListViewListener(){

			@Override
			public void onClickFrontView(int position) {
				super.onClickFrontView(position);
				mSwipeListView.closeOpenedItems();
				Toast.makeText(MainActivity.this, adapter.getItem(position).getTime()+getTitle()+"和你对话", 2400).show();
			}
			
			@Override
			public void onDismiss(int[] reverseSortedPositions) {
				super.onDismiss(reverseSortedPositions);
				for (int i : reverseSortedPositions) {
					datas.remove(i);
				}
				adapter.notifyDataSetChanged();
			}
			
		});
	}
	
	private void initDatas(){
		datas=new ArrayList<TestData>();
		TestData td1=new TestData("张三", "2014-7-11");
		datas.add(td1);
		TestData td2=new TestData("李四", "2014-3-18");
		datas.add(td2);
		TestData td3=new TestData("王五", "2013-11-11");
		TestData td4=new TestData("白素", "2013-7-11");
		TestData td5=new TestData("卫斯理", "2013-5-20");
		TestData td6=new TestData("曹操", "2013-2-14");
		TestData td7=new TestData("刘备", "2012-8-15");
		TestData td8=new TestData("孙权", "2012-7-7");
		TestData td9=new TestData("董卓", "2012-2-14");
		TestData td10=new TestData("王允", "2011-10-1");
		TestData td11=new TestData("貂蝉", "2011-7-7");
		datas.add(td3);
		datas.add(td4);
		datas.add(td5);
		datas.add(td6);
		datas.add(td7);
		datas.add(td8);
		datas.add(td9);
		datas.add(td10);
		datas.add(td11);
	}
	
}
