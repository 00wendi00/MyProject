/**
 * 文件名：Ex11.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-29
 */
package 第十七章深入研究容器;

/**
 * @author 张文迪
 * 类名：Ex11
 * 类说明：很好的 例子~~        //return Integer.toString(i);
 */
import java.util.*;  

class IntegerTest implements Comparable<IntegerTest> 
{
	Random r = new Random();
	Integer i = r.nextInt(100);
	public int compareTo(IntegerTest arg) 
	{
		int d = this.i - arg.i;
		return d < 0 ? -1 : (d == 0 ? 0 : 1);
	}
	public String toString() 
	{
		return Integer.toString(i);
	}
}

public class Ex11 
{
	public static void main(String[] args) 
	{
		PriorityQueue<IntegerTest> pt = 
		new PriorityQueue<IntegerTest>();
		for(int i = 0; i < 8; i++) 
		{
			pt.add(new IntegerTest());
		}
		int size = pt.size();
		for(int i = 0; i < size; i++) 
		{
			System.out.print(pt.poll() + " ");
		}
	}
} 