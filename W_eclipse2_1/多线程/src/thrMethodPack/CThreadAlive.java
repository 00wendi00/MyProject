/**
 * 文件名：CThreadAlive.java
 * 项目-包：多线程 - 老师代码
 * 作者：张文迪
 * 创建日期：2014-5-23
 */
package thrMethodPack;

import firstFeelPack.MyThread1;

/**
 * @author 张文迪
 * 类名：CThreadAlive
 * 类说明：
 */

/**
 * 线程各种方法的使用isActive。
 * 
 * @author eagler_hu
 * 
 */
public class CThreadAlive
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		MyThread1 t = new MyThread1("aa");
		t.start(); //启动一个线程，会自动调用到线程的run方法。

		/**
		 * 如果t线程处于活的状态，则不往下执行，从而可以实现两个线程同步。
		 */
		while (t.isAlive())
		{

		}

		for (int i = 0; i < 10; i++)
		{
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}
