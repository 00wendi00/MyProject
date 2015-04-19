/**
 * 文件名：MoreBasicThreads.java
 * 项目-包：JAVA编程思想 - 并发
 * 作者：张文迪
 * 创建日期：2014-11-4
 */
package 第二十一章并发;

/**
 * @author 张文迪
 * 类名：MoreBasicThreads
 * 类说明：
 */
public class MoreBasicThreads
{
	public static void main(String args[])
	{
		for(int i = 0;i<5;i++)
			new Thread(new LiftOff()).start();
		System.out.println("Start~~~~~~~~~~");
	}
}
