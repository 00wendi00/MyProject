/**
 * �ļ�����Ex14.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-8
 */
package ��ʮһ��.���ж���;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author ���ĵ�
 * ������Ex14
 * ��˵����  ���þ�̬���� addMiddle +++ ����
 */
public class Ex14 
{
	static void addMiddle(LinkedList<Integer> l, Integer[] ia) 
	{
		for(Integer i : ia) 
		{
			ListIterator<Integer> it = 
				l.listIterator((l.size())/2);
			it.add(i);
			System.out.println(l);
		}
	}
	public static void main(String[] args) 
	{
		LinkedList<Integer> li = new LinkedList<Integer>();
		Integer[] x = {0, 1, 2, 3, 4, 5, 6, 7};
		Ex14.addMiddle(li, x);
	}	
}

