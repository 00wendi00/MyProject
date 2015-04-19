/**
 * 文件名：Ex11.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-5
 */
package 第二十一章并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 张文迪
 * 类名：Ex11
 * 类说明：  卡成狗也 不能显示出 方法中的  几个++ 的非原子性 ~~~醉了 
 */
public class Ex11
{
	public static void main(String args[])
	{

			for(int i = 0;i<10;i++)
			{
				ExecutorService exec = Executors.newCachedThreadPool();
				exec.execute(new myClass11());
				Thread.yield();
				exec.shutdown();
			}
		
	}
}
class myClass11 implements Runnable
{
	private  int p1 = 0;
	private  int p2 = 0;
	public int haha11() 
	{
		while(true)
		{
			++p1 ;
			Thread.yield();
			++p1 ;
			Thread.yield();
			++p2 ;
			Thread.yield();
			++p2 ;
			return p1+p2;
		}
	}
	public int getvalue() {return p1+p2 ;}
	public void run()
	{
		while(true)
		{
			int  k = getvalue();
			k = haha11();
			if(k % 2 !=0)
			{
				System.out.println(k);
				break ;
			}
		}
	}
}
