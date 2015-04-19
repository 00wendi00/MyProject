/**
 *�ļ���:BookContent.java
 *��Ŀ-��:Project4_4_4,com.example.project4_4_4
 *����:���ĵ�
 *ʱ��:2015��4��4��
 */
package com.example.project4_4_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ���ĵ�
 * ����:BookContent
 * ��˵��:
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
		addItem(new Book(1, "ս�����ƽ", "����"));
		addItem(new Book(2, "����", "�ǳ��õ��鼮~~~~~~~~~~~~~~~~~~~~~~"));
		addItem(new Book(3, "������ʱ��", "@@@@@#####$$$$$$$"));
	}
	private static void addItem(Book book){
		ITEMS.add(book);
		ITEM_MAP.put(book.id, book);
	}
}
