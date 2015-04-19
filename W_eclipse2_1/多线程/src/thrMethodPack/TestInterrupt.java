/**
 * 文件名：TestInterrupt.java
 * 项目-包：多线程 - thrMethodPack
 * 作者：张文迪
 * 创建日期：2014-5-23
 */
package thrMethodPack;

/**
 * @author 张文迪
 * 类名：TestInterrupt
 * 类说明：
 */


import java.util.*;

public class TestInterrupt
{
	static boolean flag;
	public static void main(String[] args)
	{
		MyThread thread = new MyThread();
		thread.start();
		try
		{
			Thread.sleep(10000);
		}
		catch (InterruptedException e)
		{
		}
		//thread.interrupt();  //比较粗暴，切忌不要用stop，更加粗暴
		flag =false;
	}
}

class MyThread extends Thread
{
	

	public void run()
	{
		boolean flag = true;  //比较好的停止线程的方法。
		while (flag)
		{
			System.out.println("===" + new Date() + "===");
			try
			{
				sleep(1000);
			}
			catch (InterruptedException e)
			{
				return;
			}
		}
	}
}
/*
 * public void run() { while (true) { String temp = new Date().toString();
 * String t = temp.substring(11, temp.indexOf('C')); t = t.trim(); String[] time
 * = t.split(":"); if (time.length == 3) { System.out.println(“现在是” + time[0] +
 * “点” + time[1] + "分" + time[2] + "秒"); } try { Thread.sleep(5000); } catch
 * (InterruptedException e) { return; } } } }
 */