/**
 * 文件名：Ex9.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-5
 */
package 第二十一章并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * @author 张文迪
 * 类名：Ex9
 * 类说明：
 */

class SimplePriorities2 implements Runnable 
{
	private int countDown = 5;
	private volatile double d; // No optimization
	public String toString()
	{
		return Thread.currentThread() + ": " + countDown;
	}
	public void run() 
	{
		for(;;) 
		{
			// An expensive, interruptable operation:
			for(int i = 1; i < 100000; i++) 
			{
				d += (Math.PI + Math.E) / (double)i;
				if(i % 1000 == 0)
					Thread.yield();
			}
			System.out.println(this);
			if(--countDown == 0) return;
		}
	}
}
class PriorityThreadFactory implements ThreadFactory 
{
	private final int priority;
	PriorityThreadFactory(int priority) 
	{
		this.priority = priority;
	}
	public Thread newThread(Runnable r) 
	{
		Thread t = new Thread(r);
		t.setPriority(priority);
		return t;
	}
}
public class Ex9 {
	public static void main(String[] args) 
	{
		ExecutorService exec = Executors.newCachedThreadPool(
								new PriorityThreadFactory(Thread.MIN_PRIORITY));
		for(int i = 0; i < 5; i++)
			exec.execute(new SimplePriorities2());
		Thread.yield();
		exec.shutdown(); //启动一次顺序关闭，执行以前提交的任务，但不接受新任务.如果已经关闭，则调用没有其他作用
		
		exec = Executors.newCachedThreadPool(
				new PriorityThreadFactory(Thread.MAX_PRIORITY));
		exec.execute(new SimplePriorities2());  
		     //在未来某个时间执行给定的命令。该命令可能在新的线程、已入池的线程或者正调用的线程中执行，这由 Executor 实现决定
		Thread.yield();
		exec.shutdown();
	}
}