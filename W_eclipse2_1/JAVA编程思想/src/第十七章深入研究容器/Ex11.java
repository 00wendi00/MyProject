/**
 * �ļ�����Ex11.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���������о�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-29
 */
package ��ʮ���������о�����;

/**
 * @author ���ĵ�
 * ������Ex11
 * ��˵�����ܺõ� ����~~        //return Integer.toString(i);
 */
import java.util.*;  

class IntegerTest implements Comparable<IntegerTest> 
{
	Random r = new Random();
	Integer i = r.nextInt(100);
	public int compareTo(IntegerTest arg) 
	{
		int d = this.i - arg.i;
		return d < 0 ? -1 : (d == 0 ? 0 : 1);
	}
	public String toString() 
	{
		return Integer.toString(i);
	}
}

public class Ex11 
{
	public static void main(String[] args) 
	{
		PriorityQueue<IntegerTest> pt = 
		new PriorityQueue<IntegerTest>();
		for(int i = 0; i < 8; i++) 
		{
			pt.add(new IntegerTest());
		}
		int size = pt.size();
		for(int i = 0; i < size; i++) 
		{
			System.out.print(pt.poll() + " ");
		}
	}
} 