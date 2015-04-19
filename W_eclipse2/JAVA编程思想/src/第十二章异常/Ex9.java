/**
 * �ļ�����Ex9.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����쳣
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-11
 */
package ��ʮ�����쳣;

/**
 * @author ���ĵ�
 * ������Ex9
 * ��˵������ϰ9,13.
 */
public class Ex9
{
	public static void f(int i) throws M1Exception,M2Exception,M3Exception
	{
		System.out.println(i);
		if(i<0)
			throw new M1Exception("��1");
		else if(i==0)
			throw new M2Exception("��2");
		else 
		{
			throw new M3Exception("��3");	
		}
	}
	public static void main(String args[])
	{
		try
		{
			Ex9 ex9 = new Ex9();
			ex9.f(1);		
		}
		catch (Exception e)
		{
			System.out.println("Catch exception!");
			e.printStackTrace(System.out);
		}
		finally
		{
			System.out.println("Finally~~~~~~~~~");
		}
	}
}
class M1Exception extends Exception
{
	public M1Exception(String s)
	{
		super(s);
	}
}
class M2Exception extends Exception
{
	public M2Exception(String s)
	{
		super(s);
	}
}
class M3Exception extends Exception
{
	public M3Exception(String s)
	{
		super(s);
	}
}
