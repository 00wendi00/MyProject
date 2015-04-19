/**
 * 文件名：DataOnly.java
 * 项目-包：JAVA编程思想 - 第一二章
 * 作者：张文迪
 * 创建日期：2014-9-2
 */
package 第一二章;

/**
 * @author 张文迪
 * 类名：DataOnly
 * 类说明：练习4,5
 */
public class DataOnly
{
	
	static int i;
    static double d;
    static boolean b;

	public static void main(String args[])
	{
     
     
     DataOnly data = new DataOnly();
     
     data.i=2;
     data.d=3;
     data.b=true;
     
     System.out.println(i);
     System.out.println(d);
     System.out.println(b);
     System.out.println(data.i);
     System.out.println(data.d);
     System.out.println(data.b);
     
     
     }
}