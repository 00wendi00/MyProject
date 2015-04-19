/**
 * 文件名：Ex6.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-4
 */
package 第二十一章并发;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 张文迪
 * 类名：Ex6
 * 类说明：       TimeUnit.MILLISECONDS.sleep(1000);	 看这个线程的休眠 ，   输出很 完美 ， 很神奇 ！！！！
 */
public class Ex6
{	
	public static void main(String args[])
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i =0;i<4;i++)
			exec.execute(new MyThread6());
	}
}
class MyThread6 implements Runnable
{
	int i = 5;
	private static int count = 0;
	private final int id = count++ ;
	MyThread6()
	{
		System.out.println("#"+id+"#"+"启动了!!!");
	}
	public String status()
	{
		return "#"+id+"#: "+(i>0? i:"结束了 ");
	}
	public void run()
	{
		Random random = new Random(47);
		int p = 0;	
		try
		{
			while(i-->0){							
				System.out.println(status());							
				p = random.nextInt(1000);   
				System.out.println(p);
				TimeUnit.MILLISECONDS.sleep(p);			  // 休眠 一秒以内的时间(随机数)				
			}
			System.out.println("结束了！！！");
		}
		catch (InterruptedException e) {
			System.err.println("Interrupt"); 
		}
	}
}
