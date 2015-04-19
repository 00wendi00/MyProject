/**
 * 文件名：Ex6.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author 张文迪
 * 类名：Ex6
 * 类说明：
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
			System.err.println("完成！");
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

