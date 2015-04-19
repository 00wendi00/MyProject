/**
 * 文件名：Ex21.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-6
 */
package 第二十一章并发;

import static net.mindview.util.Print.print;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 张文迪
 * 类名：Ex21
 * 类说明：这个例子也是精髓~~~synchronized用法也是极好的 ！！！
 */
class Coop1 implements Runnable 
{
	public Coop1() { print("Constructed Coop1"); }
	public void run() 
	{
		print("Coop1 going into wait");
		synchronized(this)               // 不能对整个方法用synchronized~~   而应该这样用！！！
		{
			try {
				wait();
				System.out.println("!!!!!!!!!");
			} catch(InterruptedException ignore) {}
		}
		print("Coop1 exited wait");
	}
}
class Coop2 implements Runnable 
{
	Runnable otherTask;
	public Coop2(Runnable otherTask) 
	{
		this.otherTask = otherTask;
		print("Constructed Coop2");
	}
	public void run() 
	{
		print("Coop2 pausing 5 seconds");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch(InterruptedException ignore) {}
		print("Coop2 calling notifyAll");
		synchronized(otherTask) { otherTask.notifyAll(); }      // 吧对象(coop1)这样传进来了， 然后唤醒 coop1
															   // 太神奇了 ~~~
	}
}
public class Ex21 
{
	public static void main(String args[]) throws Exception
	{
		Runnable coop1 = new Coop1(),
		coop2 = new Coop2(coop1);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(coop1);
		exec.execute(coop2);
		Thread.yield();  // 这个东西~~意义不大
		exec.shutdown();
	}
}
