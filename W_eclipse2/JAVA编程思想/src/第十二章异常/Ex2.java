/**
 * �ļ�����Ex2.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����쳣
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-11
 */
package ��ʮ�����쳣;

/**
 * @author ���ĵ�
 * ������Ex2
 * ��˵����  try�����ǿ��ܲ����쳣�� ����~  catch ����~  finally һ����ִ��~
 */
public class Ex2
{ 
    static String s = null;
    public static void f1()
    {
    	System.out.println("Ҫ���õ� ����");
    }
    public static void main(String args[])
    {
    	try
		{
			System.out.println(s.toString());
		}
		catch (NullPointerException e)
		{
			System.out.println("Caught NullPointerException");
			e.printStackTrace();
		}
		try {
			s = "~~~~~~~~~";
			System.out.println(s.toString());
		} catch(NullPointerException e) {
			System.err.println("Caught NullPointerException");
			e.printStackTrace();
		} finally {
			System.out.println("Got through it");
		}
    }
}  
