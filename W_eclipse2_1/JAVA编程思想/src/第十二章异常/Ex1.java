/**
 * 文件名：Ex1.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：Ex1
 * 类说明： 传递字符串参数  给exception构造器~~~
 */
public class Ex1
{
	public static void f() throws MyException
	{
		System.out.println("Throws my exception from f()");
		throw new MyException("哈哈！！！！！！！！"); //传递字符串参数  给exception构造器~~~
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
		System.out.println("执行了！@！！");
	}
  }
}
class MyException extends Exception
{
	public MyException() {}
	public MyException(String s) {super(s);} //!!!!!!!!
}


