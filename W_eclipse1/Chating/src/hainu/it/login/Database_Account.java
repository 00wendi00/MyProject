package hainu.it.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database_Account extends SQLiteOpenHelper
{
	final String CREATE_TABLE_SQL = "create table dict(_id integer primary "+"key autoincrement , account , passwd)";
	public Database_Account(Context context, String name,int version) 
	{
		super(context, name, null, version);
	}
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL(CREATE_TABLE_SQL);
	}
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// 这里是版本跟新~~  
	}

}
