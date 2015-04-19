/**
 * 文件名：Ex4.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-4
 */
package 第二十一章并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import 第十五章泛型.Fibonacci7;

/**
 * @author 张文迪
 * 类名：Ex4
 * 类说明：
 */
public class Ex4
{
	public static void main(String args[])
	{
		ExecutorService exec1 = Executors.newCachedThreadPool();
		//for(int i =1;i<=7;i++)
		//	exec1.execute(new Fibonacci(i));
		
		ExecutorService exec2 = Executors.newFixedThreadPool(5);
		//for(int i =1;i<=5;i++)
			//exec2.execute(new Fibonacci(i));
		
		ExecutorService exec3 = Executors.newSingleThreadExecutor();
		for(int i =1;i<6;i++)
			exec3.execute(new Fibonacci(i));
	}
}
