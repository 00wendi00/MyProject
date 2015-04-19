/**
 * 文件名：FailingConstructor.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-12
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：FailingConstructor
 * 类说明： 练习22~
 */
public class FailingConstructor
{
   private void dispose()
   {
	   System.out.println("清除了~~~");
   }
   FailingConstructor() throws My0Exception
   {
	   System.out.println("失败~~");
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
		System.out.println("My0Exception~哈哈 ~~~~~~");
	}
}