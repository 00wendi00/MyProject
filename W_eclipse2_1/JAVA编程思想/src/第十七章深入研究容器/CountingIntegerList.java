/**
 * �ļ�����CountingIntegerList.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���������о�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-28
 */
package ��ʮ���������о�����;

import java.util.AbstractList;

/**
 * @author ���ĵ�
 * ������CountingIntegerList
 * ��˵����  ��ʶ  AbstractList.get()  .size();    
 */
public class CountingIntegerList extends AbstractList<Integer>
{
	private int size ;
	public CountingIntegerList(int size)
	{
		this.size = size <0 ? 0:size;
	}
	public Integer get(int index)
	{		
		return Integer.valueOf(index);
	}
	public int size() {return size;}
	public static void main(String args[])
	{
		System.out.println(new CountingIntegerList(10));
	}
}
