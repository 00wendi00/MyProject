/**
 * �ļ�����Ex21.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����쳣
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-12
 */
package ��ʮ�����쳣;

/**
 * @author ���ĵ�
 * ������Ex21
 * ��˵����
 */
public class Ex21
{
	public static void main(String rags[])
	{
		try
		{
			Son1 son1 = new Son1();
			Father1 father1 = new Father1();
		}
		catch (Exception e)
		{
			System.err.println("BaseException caught in main()");
		}
		
	}
}
class Son1 extends Father1
{
	public Son1() throws Exception
	{
		super();
		System.out.println("haha~~~~~~~~~");
	}
}
class Father1 
{
	Father1() throws Exception
	{
		System.out.println("hehe1");
		throw new Exception();
	}
}