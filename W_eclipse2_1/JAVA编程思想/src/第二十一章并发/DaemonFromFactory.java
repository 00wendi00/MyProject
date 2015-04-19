/**
 * 文件名：DaemonFromFactory.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-5
 */
package 第二十一章并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author 张文迪
 * 类名：DaemonFromFactory
 * 类说明：
 */
class DaemonThreadFactory implements ThreadFactory
{
	public Thread newThread(Runnable r)
	{
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}
}
public class DaemonFromFactory implements Runnable
{
	public void run(){
		try
		{
			while(true){
				TimeUnit.MILLISECONDS.sleep(300);
				System.out.println(Thread.currentThread()+" "+ this);
			}
		}
	    catch (InterruptedException e) {
			System.out.println("interrupted");
		}
	}
	public static void main(String args[]) throws Exception
	{
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i =0;i<6;i++)
			exec.execute(new DaemonFromFactory());
		System.out.println("All Daemong started");
		TimeUnit.MILLISECONDS.sleep(600);
	}
}
