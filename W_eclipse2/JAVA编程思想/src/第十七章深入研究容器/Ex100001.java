/**
 * �ļ�����Ex10.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���������о�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-28
 */
package ��ʮ���������о�����;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author ���ĵ�
 * ������Ex10
 * ��˵����
 */
class MyClass10
{
	
}
public class Ex100001
{
	public static void main(String args[])
	{
		SortedSet<MyClass10> ss = new TreeSet<MyClass10>();
		LinkedList<MyClass10> ll = new LinkedList<MyClass10>();
		MyClass10[] a = {new MyClass10(),new MyClass10()};
		ll.add(a[0]);
		ll.add(a[0]);
		ll.add(a[1]);
		ll.add(a[1]);
		ll.add(a[1]);
		System.out.println(ll);   // ����ַ~~
		ss.add(ll.get(0));
		//ss.add(ll.get(1));
		//ss.add(ll.get(2));
		//ss.add(ll.get(3));
		System.out.println(ss);
	}
}
