/**
 * �ļ�����Apple123456.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-29
 */
package ��ʮһ��.���ж���;

import java.util.ArrayList;

/**
 * @author ���ĵ�
 * ������Apple123456
 * ��˵��������~
 */
class Apple
{
	private static long counter;
	private final long id = counter++;
	public long id()
	{
		return id;
	}
}
public class Apple123456
{
   public static void main(String args[])
   {
	   ArrayList<Apple> apples = new ArrayList<Apple>();
	   for(int i =0;i<6;i++)
		   apples.add(new Apple());
	   for(Apple a : apples)
		   System.out.println(a.id());
   }
}

