/**
 * �ļ�����Sequence.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-29
 */
package ��ʮһ��.���ж���;

import java.util.ArrayList;

/**
 * @author ���ĵ�
 * ������Sequence
 * ��˵���� ��ϰ3 �� �������滻���б� ~~
 */
interface Selector 
{
	boolean end();
	Object current();
	void next();
}

public class Sequence
{
	private ArrayList<Object> items = new ArrayList<Object>();
	public void add(Object x) 
	{
		items.add(x);
	}
	public Selector selector() 
	{
		return new SequenceSelector();
	}
	private class SequenceSelector implements Selector 
	{
		private int i = 0;
		public boolean end() 
		{
			return i == items.size(); 
		}
		public Object current() 
		{
			return items.get(i); 
		}
		public void next() 
		{
			i++; 
		} 
	}
	public static void main(String[] args) 
	{
		Sequence sequence = new Sequence();
		for(int i = 0; i < 10 ; i++)
			sequence.add(i);
		Selector selector = sequence.selector();
		while(!selector.end())
		{
			System.out.print(selector.current() + " ");
			selector.next();
		}
		sequence.add(10);
		sequence.add(11);
		sequence.add(12);
		sequence.add(13);
		sequence.add("good bye ����");
		while(!selector.end()) 
		{
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
}
