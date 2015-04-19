/**
 * 文件名：Ex2.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：Ex2
 * 类说明：  try块中是可能产生异常的 区域~  catch 捕获~  finally 一定会执行~
 */
public class Ex2
{ 
    static String s = null;
    public static void f1()
    {
    	System.out.println("要调用的 方法");
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
