/**
 * 文件名：TestPriority.java
 * 项目-包：多线程 - thrMethodPack
 * 作者：张文迪
 * 创建日期：2014-5-23
 */
package thrMethodPack;

/**
 * @author 张文迪
 * 类名：TestPriority
 * 类说明：
 */


public class TestPriority
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread t1 = new Thread(new T1());
		Thread t2 = new Thread(new T2());
		//t1.setPriority(Thread.NORM_PRIORITY + 3);
		t1.start();
		t2.start();
		t1.join();
	}
}

class T1 implements Runnable
{
	public void run()
	{
		for (int i = 0; i < 1000; i++)
		{
			System.out.println("T1: " + i);
		}
	}
}

class T2 implements Runnable
{
	public void run()
	{
		for (int i = 0; i < 1000; i++)
		{
			System.out.println("------T2: " + i);
		}
	}
}