/**
 * 文件名：BasicThreads.java
 * 项目-包：JAVA编程思想 - 并发
 * 作者：张文迪
 * 创建日期：2014-11-4
 */
package 第二十一章并发;

/**
 * @author 张文迪
 * 类名：BasicThreads
 * 类说明：
 */
public class BasicThreads
{
	public static void main(String args[])
	{
		Thread t = new Thread(new LiftOff());
		t.start();
		System.out.println("Start~~~~~~~~~");
	}
}
