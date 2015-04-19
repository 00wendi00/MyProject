/**
 * 文件名：Ex11.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：Ex11
 * 类说明：
 */
public class Ex11 
{
	static void f() 
	{
		try 
		{
			g();
		} 
		catch(GException ge) 
		{
			System.out.println("Caught GException in f try");
			ge.printStackTrace();
			throw new RuntimeException(ge);// 包装成  运行时异常~
		}
	}
	static void g() throws GException 
	{
		throw new GException("from g()");
	}
	public static void main(String[] args) 
	{
		f();
	}	
}
