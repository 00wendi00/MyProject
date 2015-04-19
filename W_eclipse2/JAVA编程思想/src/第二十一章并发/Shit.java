/**
 * 文件名：shit.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-5
 */
package 第二十一章并发;

/**
 * @author 张文迪
 * 类名：shit
 * 类说明：++i  和 i++ 都加了一， 不过i++ 输出 i(没加1 的 ) ；   ++i则输出 (++i)
 */
public class Shit
{
	public static void main(String args[])
	{
		int count = 0;
		System.out.println(count ++);
		System.out.println(count);
		System.out.println(++count);
		System.out.println(count);
	}
}
