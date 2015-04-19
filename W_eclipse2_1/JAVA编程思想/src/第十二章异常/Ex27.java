/**
 * 文件名：Ex27.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-12
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：Ex27
 * 类说明：Exception in thread "main" java.lang.RuntimeException: java.lang.ArrayIndexOutOfBoundsException: 2
 */
public class Ex27 
{
	private static int[] ia = new int[2];	
	public static void main(String[] args) 
	{
		try 
		{
			ia[2] = 3;	
		} 
		catch(ArrayIndexOutOfBoundsException e) 
		{ 
			throw new RuntimeException(e);
		} 
	}	
}
