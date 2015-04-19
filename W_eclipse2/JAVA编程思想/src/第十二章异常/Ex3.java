/**
 * 文件名：Ex3.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：Ex3
 * 类说明：
 */
public class Ex3 
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
			System.err.println(
				"Caught ArrayIndexOutOfBoundsException");
			e.printStackTrace();
		}
	}	
}
