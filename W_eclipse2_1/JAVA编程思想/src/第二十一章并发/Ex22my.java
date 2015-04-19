/**
 * 文件名：Ex22.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-6
 */
package 第二十一章并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 张文迪
 * 类名：Ex22
 * 类说明： 我的这个例子搞定了       ：  最后通过调用静态方法 ，得到&返回了 b     ~~~  
 * 				                 ：  volatile这个修饰 b是的读取b的之前，知道了b的写入
 */
class Fool1 implements Runnable{
	volatile static boolean b = false;
	static boolean getb(){
		return b;
	}
	static  void setb(boolean c){
		b = !c;
	}
	public  void run(){
		try
		{
			TimeUnit.SECONDS.sleep(3);
			b = true;
			System.out.println(b);
		}
		catch (InterruptedException e)
		{
			// TODO: handle exception
		}
	}
}
class Fool2 implements Runnable{
	public void run(){
		while(!Thread.interrupted()) {
			if(Fool1.getb()==true)
			{
				System.out.println("!!!!!!!!!!");
				Fool1.setb(Fool1.getb());	
			}
		}	
	}
}

public class Ex22my
{
	public static void main(String args[]) throws Exception
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Fool1());
		exec.execute(new Fool2());
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}
}
