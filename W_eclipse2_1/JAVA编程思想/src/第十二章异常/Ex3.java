/**
 * �ļ�����Ex3.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����쳣
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-11
 */
package ��ʮ�����쳣;

/**
 * @author ���ĵ�
 * ������Ex3
 * ��˵����
 */
public class Ex3 
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
			System.err.println(
				"Caught ArrayIndexOutOfBoundsException");
			e.printStackTrace();
		}
	}	
}
