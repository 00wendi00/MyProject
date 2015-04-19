/**
 * 文件名：Ex10.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-5
 */
package 第二十一章并发;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 张文迪
 * 类名：Ex10
 * 类说明：
 */
class FibonacciSum2 
{
	private static ExecutorService exec;
	private static int fib(int n) 
	{
		if(n < 2) return 1;
		return fib(n-2) + fib(n-1);
	}
	public static synchronized Future<Integer> runTask(final int n)
	{
		assert exec != null;    // 断言 assert 我也是醉了 ~~~
		return exec.submit(new Callable<Integer>()    //提交一个返回值的任务用于执行，返回一个表示任务的未决结果的 Futur
		{
			public Integer call() 
			{
				int sum = 0;
				for(int i = 0; i < n; i++)
					sum += fib(i);
				return sum;
			}
		});
	}
	public static synchronized void init()
	{
		if(exec == null)
			exec = Executors.newCachedThreadPool();
	}
	public static synchronized void shutdown()
	{
		if(exec != null)
			exec.shutdown();
		exec = null;
	}
}
public class Ex10 
{
	public static void main(String[] args) 
	{
		ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
		FibonacciSum2.init();
		for(int i = 1; i <= 5; i++)
			results.add(FibonacciSum2.runTask(i));
		Thread.yield();
		FibonacciSum2.shutdown();
		for(Future<Integer> fi : results)
			try {
				System.out.println(fi.get());
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
}