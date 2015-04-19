/**
 * 文件名：Ex2.java
 * 项目-包：JAVA编程思想 - 并发
 * 作者：张文迪
 * 创建日期：2014-11-4
 */
package 第二十一章并发;

import java.util.Arrays;
import net.mindview.util.Generator;

/**
 * @author 张文迪
 * 类名：Ex2
 * 类说明：调用方法   来得到  斐波拉契 数 更好!!!
 */
class Fibonacci implements Generator<Integer>, Runnable 
{
	private int count;
	private final int n;
	public Fibonacci(int n) { this.n = n; }
	public Integer next() { return fib(count++); }
	private int fib(int n) 
	{
		if(n < 2) return 1;
		return fib(n-2) + fib(n-1);
	}
	public void run() 
	{
		Integer[] sequence = new Integer[n];
		for(int i = 0; i < n; i++)
			sequence[i] = next();
		System.out.println("Seq. of " + n + ": " + Arrays.toString(sequence));
	}
}
public class Ex2 
{
	public static void main(String[] args) 
	{
		for(int i = 1; i <= 5; i++)
			new Thread(new Fibonacci(i)).start();
	}
}