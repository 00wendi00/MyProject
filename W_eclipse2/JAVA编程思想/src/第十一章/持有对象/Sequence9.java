/**
 * �ļ�����Sequence2.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-1
 */
package ��ʮһ��.���ж���;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author ���ĵ�
 * ������Sequence2
 * ��˵���� ��ϰ9��  Iterator  ~~~
 */

public class Sequence9 
{
	private ArrayList<Object> items = new ArrayList<Object>();
	public void add(Object x) 
	{
		items.add(x);
	}
	public Iterator iterator() 
	{
		return items.iterator();
	}
	public static void main(String[] args) 
	{
		Sequence9 sequence = new Sequence9();
		for(int i = 0; i < 10; i++)
			sequence.add(Integer.toString(i));
		Iterator it = sequence.iterator();
		
		while(it.hasNext()) 
		{			
			System.out.print(it.next() + " ");
		}
		
		display(sequence.iterator()); //+++
	}	
	//+++
	private static void display(Iterator iterator)
	{
		while(iterator.hasNext())
		{
			Object ob = iterator.next();
			System.out.println(ob);
		}
	}
}
