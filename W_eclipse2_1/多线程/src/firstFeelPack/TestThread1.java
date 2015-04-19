/**
 * 文件名：TestThread1.java
 * 项目-包：多线程 - firstFeelPack
 * 作者：张文迪
 * 创建日期：2014-5-23
 */
package firstFeelPack;

/**
 * @author 张文迪
 * 类名：TestThread1
 * 类说明：
 */


public class TestThread1
{
	public static void main(String args[])
	{
		Runner1 r = new Runner1();
		r.start();
		// r.run();
		// Thread t = new Thread(r);
		// t.start();

		for (int i = 0; i < 100; i++)
		{
			System.out.println("Main Thread:------" + i);
		}
	}
}

// class Runner1 implements Runnable {
class Runner1 extends Thread
{
	public void run()
	{
		for (int i = 0; i < 100; i++)
		{
			System.out.println("Runner1 :" + i);
		}
	}
}
