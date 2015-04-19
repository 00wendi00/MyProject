/**
 * 文件名：Ex5.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-4
 */
package 第二十一章并发;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import net.mindview.util.Generator;

/**
 * @author 张文迪
 * 类名：Ex5
 * 类说明：
 */
class FibonacciSum implements Generator<Integer>, Callable<Integer> 
{
	private int count;
	private final int n;
	public FibonacciSum(int n) { this.n = n; }
	public Integer next() { return fib(count++); }
	private int fib(int n) 
	{
		if(n < 2) return 1;
		return fib(n-2) + fib(n-1);
    }
	public Integer call() {
		int sum = 0;
		for(int i = 0; i < n; i++)
			sum += next();
		return sum;
	}
}
public class Ex5 
{
	public static void main(String[] args) 
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<Integer>> results =
			new ArrayList<Future<Integer>>();
		for(int i = 1; i <= 5; i++)
			results.add(exec.submit(new FibonacciSum(i)));
		Thread.yield();
		exec.shutdown();
		for(Future<Integer> fi : results)
			try {
				System.out.println(fi.get());
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
	}
}