/**
 * �ļ�����FailingConstructor.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����쳣
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-12
 */
package ��ʮ�����쳣;

/**
 * @author ���ĵ�
 * ������FailingConstructor
 * ��˵���� ��ϰ22~
 */
public class FailingConstructor
{
   private void dispose()
   {
	   System.out.println("�����~~~");
   }
   FailingConstructor() throws My0Exception
   {
	   System.out.println("ʧ��~~");
	   throw new My0Exception();
   }
   public static void main(String args[])
   {
	   try
	{
		new FailingConstructor();
	}
	catch (My0Exception e)
	{
		System.err.println("Caught Exception in main()");
		e.printStackTrace(System.err);
	}
   }
}
class My0Exception extends Exception
{
	 My0Exception()
	{
		System.out.println("My0Exception~���� ~~~~~~");
	}
}