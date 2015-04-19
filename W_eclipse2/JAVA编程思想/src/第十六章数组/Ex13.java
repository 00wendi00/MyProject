/**
 * 文件名：Ex13.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-26
 */
package 第十六章数组;

/**
 * @author 张文迪
 * 类名：Ex13
 * 类说明：
 */
import net.mindview.util.*;


public class Ex13 
{
	public static String fillString(int len) 
	{
		CountingGenerator.Character cg = new CountingGenerator.Character();
		char[] ca = new char[len];
		for(int i = 0; i < len; i++)
			ca[i] = cg.next();
		return new String(ca);		
	}
	public static void main(String[] args)
	{
		System.out.println(fillString(7));
		System.out.println(fillString(10));
	}
}
