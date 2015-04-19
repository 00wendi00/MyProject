/**
 *文件名:BookContent.java
 *项目-包:Project4_4_4,com.example.project4_4_4
 *作者:张文迪
 *时间:2015年4月4日
 */
package com.example.project4_4_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张文迪
 * 类名:BookContent
 * 类说明:
 */
public class BookContent {
	public static class Book{
		public Integer id;
		public String title;
		public String desc;
		public Book(Integer id,String title,String desc){
			this.id = id;
			this.title = title;
			this.desc = desc;
		}
		public String toString(){
			return title;
		}
	}
	public static List<Book> ITEMS = new ArrayList<BookContent.Book>();
	public static Map<Integer, Book> ITEM_MAP = new HashMap<Integer, BookContent.Book>();
	static {
		addItem(new Book(1, "战争与和平", "好书"));
		addItem(new Book(2, "看见", "非常好的书籍~~~~~~~~~~~~~~~~~~~~~~"));
		addItem(new Book(3, "大数据时代", "@@@@@#####$$$$$$$"));
	}
	private static void addItem(Book book){
		ITEMS.add(book);
		ITEM_MAP.put(book.id, book);
	}
}
