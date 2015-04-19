/**
 * 文件名：Whiletest.java
 * 项目-包：JAVA编程思想 - 第四章
 * 作者：张文迪
 * 创建日期：2014-9-4
 */
package 第四章;

/**
 * @author 张文迪
 * 类名：Whiletest
 * 类说明：while
 */
public class Whiletest
{
    static boolean condition()
    {
    	boolean result = Math.random()<0.99;
    	System.out.println(result+"");
    	return result;
    }
    
    public static void main(String args[])
    {
    	while (condition())
		{
			System.out.println("Inside 'while'");
			System.out.println("Exited'while'");
			
			
		}
    }
}
