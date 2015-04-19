/**
 * 文件名：SimpleDaemons.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-5
 */
package 第二十一章并发;

import java.util.concurrent.TimeUnit;

/**
 * @author 张文迪
 * 类名：SimpleDaemons
 * 类说明： Thread.setDaemon(boolean);  后台线程~~
 */
public class SimpleDaemons implements Runnable
{
	public void run(){
		try
		{
			while(true){
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.println(Thread.currentThread()+" "+this);   //返回对当前正在执行的线程对象的引用
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("Sleep() interrupted");
		}
	}
	public static void main(String args[]) throws Exception
	{
		for(int i =0;i<10;i++){
			Thread deamon = new Thread(new SimpleDaemons());
			deamon.setDaemon(true);
			deamon.start();
		}
		System.out.println("All start");
		TimeUnit.MILLISECONDS.sleep(5000);   //执行5秒后，main()线程结束，后台线程同时终止~~
	}
}
