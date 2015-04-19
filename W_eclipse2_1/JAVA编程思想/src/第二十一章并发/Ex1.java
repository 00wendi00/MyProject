/**
 * 文件名：Ex1.java
 * 项目-包：JAVA编程思想 - 并发
 * 作者：张文迪
 * 创建日期：2014-11-4
 */
package 第二十一章并发;

/**
 * @author 张文迪
 * 类名：Ex1
 * 类说明：
 */
public class Ex1
{	
	public static void main(String args[])
	{
		for(int i =0;i<3;i++)
		{
			Thread t = new Thread(new MyThread());
			t.start();
		}
	}
}
class MyThread implements Runnable
{
	int i = 5;
	private static int count = 0;
	private final int id = count++ ;
	MyThread()
	{
		System.out.println("#"+id+"#"+"启动了!!!");
	}
	public String status()
	{
		return "#"+id+"#: "+(i>0? i:"结束了 ");
	}
	public void run()
	{
		while(i-->0){					
			System.out.println(status());
			Thread.yield();		
		}
		System.out.println("结束了！！！");
	}
}
