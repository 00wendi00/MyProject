/**
 * �ļ�����Ex9.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���������о�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-28
 */
package ��ʮ���������о�����;

import java.util.TreeSet;

import net.mindview.util.RandomGenerator;

/**
 * @author ���ĵ�
 * ������Ex9
 * ��˵����TreeSet<String> ts = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER); //!!!
 */
public class Ex9 
{
	public static void main(String[] args) 
	{
		TreeSet<String> ts = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);  
		                                       //һ���� String ������������ Comparator�������� compareToIgnoreCase ��ͬ
		RandomGenerator.String rgs = new RandomGenerator.String(5);
		for(int i = 0; i < 8; i++) 
		{
			ts.add(rgs.next());
		}
		System.out.println(ts);
	}
}
