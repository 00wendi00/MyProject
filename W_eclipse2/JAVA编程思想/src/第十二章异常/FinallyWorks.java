/**
 * 文件名：FinallyWorks.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：FinallyWorks
 * 类说明：  ++count 表示    结果=count+1;   count++ 表示   结果=count; count+1;  
 */
class ThreeException extends Exception {}
public class FinallyWorks
{
	static int count = 0;
	public static void main(String args[])
	{
		while(true)
		{
			try
			{
				if(count++ == 0)
				{				
					System.out.println(count);
					throw new ThreeException();
				}
				System.out.println("No Exception");
			}
			catch (ThreeException e)
			{
				System.out.println("ThreeExcption");
			}
			finally
			{
				System.out.println("Finally");
			}
			if(count == 2)
				break;
		}
	}
}
