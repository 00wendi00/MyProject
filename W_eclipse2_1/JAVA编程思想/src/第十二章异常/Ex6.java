/**
 * �ļ�����Ex6.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����쳣
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-11
 */
package ��ʮ�����쳣;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author ���ĵ�
 * ������Ex6
 * ��˵����
 */
public class Ex6
{
	public static void main(String args[])
	{
		try
		{
			throw new My61Exception();
		}
		catch (My61Exception e)
		{
			System.err.println("61~~~~~");
			System.err.println(e);
			System.out.println();
			System.out.println();
		}
		try
		{
			throw new My62Exception();
		}
		catch (My62Exception e)
		{
			System.err.println("62~~~~~");
			System.err.println(e);
		}
		finally
		{
			System.err.println("��ɣ�");
		}
	}
}
class My61Exception extends Exception
{
	private static Logger logger = Logger.getLogger("61  Logger Exception!!!!!");
	public My61Exception()
	{
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}
class My62Exception extends Exception
{
	private static Logger logger = Logger.getLogger("62  Logger Exception!!!!!");
	public My62Exception()
	{
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

