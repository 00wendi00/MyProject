/**
 * 文件名：Ex9.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-26
 */
package 第十六章数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张文迪
 * 类名：Ex9
 * 类说明：
 */
class Banana 
{
	private static long counter;
	private final long id = counter++;
	public String toString() { return "Banana " + id; }	
}

class Peel<T> 
{
	private T t;
	private static long counter;
	private final long id = counter++;
	public Peel(T t) { this.t = t; } 
	public String toString() { return "Peel " + id + " " + t.toString(); }
}

public class Ex9<T> 
{
	public static void main(String[] args) 
	{
		// error: generic array creation:
		//Peel<Banana>[] peels = new Peel<Banana>[10];
		List<Peel<Banana>> peels = new ArrayList<Peel<Banana>>();
		for(int i = 0; i < 10; i++)
			peels.add(new Peel<Banana>(new Banana())); 
		System.out.println(peels);
		System.out.println("peels.get(0).getClass(): " + peels.get(0).getClass());		
	}	
}
