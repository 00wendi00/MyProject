/**
 * �ļ�����FinallyWorks.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����쳣
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-11
 */
package ��ʮ�����쳣;

/**
 * @author ���ĵ�
 * ������FinallyWorks
 * ��˵����  ++count ��ʾ    ���=count+1;   count++ ��ʾ   ���=count; count+1;  
 */
class ThreeException extends Exception {}
public class FinallyWorks
{
	static int count = 0;
	public static void main(String args[])
	{
		while(true)
		{
			try
			{
				if(count++ == 0)
				{				
					System.out.println(count);
					throw new ThreeException();
				}
				System.out.println("No Exception");
			}
			catch (ThreeException e)
			{
				System.out.println("ThreeExcption");
			}
			finally
			{
				System.out.println("Finally");
			}
			if(count == 2)
				break;
		}
	}
}
