/**
 * �ļ�����Ex27.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����쳣
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-12
 */
package ��ʮ�����쳣;

/**
 * @author ���ĵ�
 * ������Ex27
 * ��˵����Exception in thread "main" java.lang.RuntimeException: java.lang.ArrayIndexOutOfBoundsException: 2
 */
public class Ex27 
{
	private static int[] ia = new int[2];	
	public static void main(String[] args) 
	{
		try 
		{
			ia[2] = 3;	
		} 
		catch(ArrayIndexOutOfBoundsException e) 
		{ 
			throw new RuntimeException(e);
		} 
	}	
}
