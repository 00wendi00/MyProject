/**
 * 文件名：TestYield.java
 * 项目-包：多线程 - thrMethodPack
 * 作者：张文迪
 * 创建日期：2014-5-23
 */
package thrMethodPack;

/**
 * @author 张文迪
 * 类名：TestYield
 * 类说明：
 */

public class TestYield
{
	public static void main(String[] args)
	{
		MyThread4 th1 = new MyThread4("t1");
		MyThread4 th2 = new MyThread4("t2");
		th1.start();
		th2.start();
	}
}

class MyThread4 extends Thread
{
	MyThread4(String s)
	{
		super(s);
	}

	public void run()
	{
		for (int i = 1; i <= 100; i++)
		{
			System.out.println(getName() + ": " + i);
			if (i % 10 == 0)
			{
				yield();  //当前线程让出cpu，让其他线程运行。
			}
		}
	}
}
