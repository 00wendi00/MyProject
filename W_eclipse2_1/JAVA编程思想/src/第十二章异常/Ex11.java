/**
 * �ļ�����Ex11.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����쳣
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-11
 */
package ��ʮ�����쳣;

/**
 * @author ���ĵ�
 * ������Ex11
 * ��˵����
 */
public class Ex11 
{
	static void f() 
	{
		try 
		{
			g();
		} 
		catch(GException ge) 
		{
			System.out.println("Caught GException in f try");
			ge.printStackTrace();
			throw new RuntimeException(ge);// ��װ��  ����ʱ�쳣~
		}
	}
	static void g() throws GException 
	{
		throw new GException("from g()");
	}
	public static void main(String[] args) 
	{
		f();
	}	
}
