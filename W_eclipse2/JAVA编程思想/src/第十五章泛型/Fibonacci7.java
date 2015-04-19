/**
 * 文件名：Fibonacci7.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-21
 */
package 第十五章泛型;

/**
 * @author 张文迪
 * 类名：Fibonacci7
 * 类说明：
 */
import net.mindview.util.*;
import java.util.*;

public class Fibonacci7 implements Generator<Integer>, Iterable<Integer> 
{
	private int count = 0;
	private int m;
	public Integer next() { return fib(count++); }
	private int fib(int n) 
	{
		if(n < 2) return 1;
		return fib(n - 2) + fib(n - 1);
	}
	public Fibonacci7() {}
	public Fibonacci7(int m) { this.m = m; }
	public Iterator<Integer> iterator() 
	{
		return new Iterator<Integer>() 
		{
			public boolean hasNext() { return m > 0; }
			public Integer next() 
			{
				m--;
				return Fibonacci7.this.next();
			}
			public void remove() 
			{ // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) 
	{
		Fibonacci7 gen = new Fibonacci7();
		for(int i = 0; i < 18; i++)
			System.out.print(gen.next() + " ");
		System.out.println();
		Iterator it = new Fibonacci7(20).iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
	}
	
}