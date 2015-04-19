/**
 * 文件名：Ex9.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：Ex9
 * 类说明：练习9,13.
 */
public class Ex9
{
	public static void f(int i) throws M1Exception,M2Exception,M3Exception
	{
		System.out.println(i);
		if(i<0)
			throw new M1Exception("额1");
		else if(i==0)
			throw new M2Exception("额2");
		else 
		{
			throw new M3Exception("额3");	
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
