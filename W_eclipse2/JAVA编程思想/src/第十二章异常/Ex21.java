/**
 * 文件名：Ex21.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-12
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：Ex21
 * 类说明：
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