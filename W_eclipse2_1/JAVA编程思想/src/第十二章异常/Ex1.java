/**
 * �ļ�����Ex1.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����쳣
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-11
 */
package ��ʮ�����쳣;

/**
 * @author ���ĵ�
 * ������Ex1
 * ��˵���� �����ַ�������  ��exception������~~~
 */
public class Ex1
{
	public static void f() throws MyException
	{
		System.out.println("Throws my exception from f()");
		throw new MyException("��������������������"); //�����ַ�������  ��exception������~~~
	}
  public static void main(String args[])
  {
	  try
	{
		f();
	}
	catch (Exception e)
	{
		e.printStackTrace(System.err);
	}
	finally
	{
		System.out.println("ִ���ˣ�@����");
	}
  }
}
class MyException extends Exception
{
	public MyException() {}
	public MyException(String s) {super(s);} //!!!!!!!!
}


