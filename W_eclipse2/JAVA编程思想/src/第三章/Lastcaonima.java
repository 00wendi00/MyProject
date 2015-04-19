/**
 * 文件名：Lastcaonima.java
 * 项目-包：JAVA编程思想 - 第三章
 * 作者：张文迪
 * 创建日期：2014-9-3
 */
package 第三章;

/**
 * @author 张文迪
 * 类名：Lastcaonima
 * 类说明：练习14+++命令行参数
 */
public class Lastcaonima
{
	public static void main(String args[])
	{
		String s1;
		String s2;
		s1 = args[0];
		s2 = args[1];
		if(s1==s2)
		{
			System.out.println("相等");
		}
		else
		{
			System.out.println("不等");
		}
		if(s1.equals(s2))
		{
			System.out.println("相等");
			
		}
		else 
		{
			System.out.println("不等");
		}
		
		System.out.println(args[0]);
		
		
		if(args.length==0)                     //没有向命令行输入参数的情况
		    System.out.println("No command line arguments");
		  else                                   //向命令行输入参数
		      {
		       System.out.println("Command line arguments were: ");
		       for(int i=0;i<args.length;i++)    //循环输出命令行数组接收到的参数
		           System.out.println("Argument"+(i+1)+":"+args[i]);
		      }
	}
}
