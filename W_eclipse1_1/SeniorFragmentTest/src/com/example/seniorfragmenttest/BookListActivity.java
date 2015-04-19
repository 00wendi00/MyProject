/**
 *文件名:BookListActivity.java
 *项目-包:Project4_4_4,com.example.project4_4_4
 *作者:张文迪
 *时间:2015年4月5日
 */
package com.example.seniorfragmenttest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author 张文迪
 * 类名:BookListActivity
 * 类说明:
 */
public class BookListActivity extends Activity implements BookListFragment.Callbacks
{
	private boolean mTwoPane;
	@SuppressLint("NewApi")
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_list);
		if(findViewById(R.id.book_detail_container) != null){
			mTwoPane = true;
			((BookListFragment)getFragmentManager().findFragmentById(R.id.book_list)).setActivateOnItemClick(true);
		}
	}
	
	
	@SuppressLint("NewApi")
	public void onItemSelected(Integer id) {
		if(mTwoPane){
			Bundle arguments = new Bundle();
			arguments.putInt(BookDetailFragment.ITEM_ID,id);
			BookDetailFragment fragment = new BookDetailFragment();
			fragment.setArguments(arguments);
			getFragmentManager().beginTransaction().replace(R.id.book_detail_container, fragment).commit();
		}
		else {
			Intent detailIntent = new Intent(this,BookDetailFragment.class);
			detailIntent.putExtra(BookDetailFragment.ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
}
