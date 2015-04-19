/**
 * 文件名：CFirstThread.java
 * 项目-包：多线程 - firstFeelPack
 * 作者：张文迪
 * 创建日期：2014-5-23
 */
package firstFeelPack;

/**
 * @author 张文迪
 * 类名：CFirstThread
 * 类说明：
 */

/**
 * 线程初体验
 * @author eagler_hu
 *
 */
class MyThread1 implements Runnable
{

	@Override
	public void run()
	{
        for (int i = 0; i <1000; i++)
		{
			System.out.println("my thread:"+i);
		}
	}
}

public class CFirstThread
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
           //MyThread thr = new MyThread();
           //thr.start();  //启动一个线程，会自动调用到线程的run方法。
		   MyThread1 thread1 = new MyThread1();
		   Thread thr = new Thread(thread1);
		   thr.start();
           
           for (int i = 0; i <1000; i++)
   		   {
   			    System.out.println("main:"+i);
   		   }
	}

}

