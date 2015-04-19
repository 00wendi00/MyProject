package com.example.project4_4_4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class Project4_4_4 extends Activity {
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_project4_4_4);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		if(savedInstanceState == null){
			BookDetailFragment fragment = new BookDetailFragment();
			Bundle arguments = new Bundle();
			arguments.putInt(BookDetailFragment.ITEM_ID, getIntent().getIntExtra(BookDetailFragment.ITEM_ID, 0));
			fragment.setArguments(arguments);
			getFragmentManager().beginTransaction().add(R.id.book_detail_container, fragment).commit();
		}
	}
	public boolean onOptionsItemSelected(MenuItem item){
		if(item.getItemId() == android.R.id.home){
			Intent intent = new Intent(this,BookListActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
