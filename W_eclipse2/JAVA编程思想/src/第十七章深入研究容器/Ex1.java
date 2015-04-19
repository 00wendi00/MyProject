/**
 * �ļ�����Ex1.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���������о�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-28
 */
package ��ʮ���������о�����;

import java.util.*;
import net.mindview.util.*;

/**
 * @author ���ĵ�
 * ������Ex1
 * ��˵���� shuffle()ʹ��Ĭ�����Դ��ָ���б�����û�~ ;  sort()����Ԫ�ص���Ȼ˳�� ��ָ���б������������  ~~  132...ABC...abc...
 */
public class Ex1 
{
	public static void main(String[] args) 
	{
		List<String> al = new ArrayList<String>();
		List<String> ll = new LinkedList<String>();
		for(int i = 0; i < Countries.DATA.length; i++) 
		{
			al.add(Countries.DATA[i][0]);
			ll.add(Countries.DATA[i][1]);
		}
		System.out.println("Countries: " + al);
		System.out.println("Capitals: " + ll);
		Collections.sort(al);
		Collections.sort(ll); // abcdefg~~~
		System.out.println("Countries: " + al);
		System.out.println("Capitals: " + ll);
		for(int i = 0; i < 2; i++) 
		{
			Collections.shuffle(al);
			Collections.shuffle(ll);
			System.out.println("Countries " + i + ": " + al);
			System.out.println("Capitals " + i + ": " + ll);
		}
		List<String> al2 = new ArrayList<String>();
		List<String> ll2 = new LinkedList<String>();
		for(int i = 0; i < 4; i++) 
		{
			al2.add(Countries.DATA[i][0]);
			ll2.add(Countries.DATA[i][0]);
		}
		for(int i = 0; i < 3; i++) 
		{
			Collections.shuffle(al2);
			Collections.shuffle(ll2);
			System.out.println("Countries " + i + ": " + al2);
			System.out.println("Capitals " + i + ": " + ll2);
			Collections.sort(al2);
			Collections.sort(ll2);
			System.out.println("Countries " + i + ": " + al2);
			System.out.println("Capitals " + i + ": " + ll2);
		}
	}
}
