/**
 * �ļ�����Ex9.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-5
 */
package �ڶ�ʮһ�²���;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * @author ���ĵ�
 * ������Ex9
 * ��˵����
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
		exec.shutdown(); //����һ��˳��رգ�ִ����ǰ�ύ�����񣬵�������������.����Ѿ��رգ������û����������
		
		exec = Executors.newCachedThreadPool(
				new PriorityThreadFactory(Thread.MAX_PRIORITY));
		exec.execute(new SimplePriorities2());  
		     //��δ��ĳ��ʱ��ִ�и��������������������µ��̡߳�����ص��̻߳��������õ��߳���ִ�У����� Executor ʵ�־���
		Thread.yield();
		exec.shutdown();
	}
}