/**
 * 文件名：Ex7.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-5
 */
package 第二十一章并发;

import java.util.concurrent.TimeUnit;

/**
 * @author 张文迪
 * 类名：Ex7
 * 类说明： main()退出 吗后台线程就死了！
 */
class Daemon implements Runnable{
	private Thread[] t = new Thread[1000];
	public void run(){
		for(int i = 0;i<t.length;i++)
		{
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DaemonSpawn "+ i +" Started, ");
		}
		for(int i =0;i<t.length;i++)
			System.out.println("t["+i+"].isDaemon = "+ t[i].isDaemon()+" ,");
		while(true)
			Thread.yield();
	}
}
class DaemonSpawn implements Runnable{
	public void run(){
		while(true)
			Thread.yield();
	}
}
public class Ex7
{
	public static void main(String args[]) throws Exception
	{
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		System.out.println("d.isDaemon = " +d.isDaemon()+" , ");
		TimeUnit.MILLISECONDS.sleep(100);
	}
}
