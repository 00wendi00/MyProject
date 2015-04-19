/**
 * 文件名：Ex41.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-30
 */
package 第十七章深入研究容器;

import java.util.HashMap;
import java.util.HashSet;

import net.mindview.util.CollectionData;
import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;

/**
 * @author 张文迪
 * 类名：Ex41
 * 类说明：
 */
class TwoString2 implements Comparable<TwoString2> 
{
	String s1, s2;
	public TwoString2(String s1i, String s2i) 
	{
		s1 = s1i;
		s2 = s2i;
	}
	public String toString() 
	{
		return "[s1 = " + s1 + ", s2 = " + s2 + "]";
	}
	public int compareTo(TwoString2 rv) 
	{
		String rvi = rv.s1;
		return s1.compareTo(rvi);
	}
	public int hashCode()   // 综合前面的 知识 ~~~
	{
		// Since the comparisons are based on s1,
		// use s1's hashCode:
		return s1.hashCode();
	}
	public boolean equals(Object obj) // 综合前面的 知识 ~~~
	{
		return obj instanceof TwoString2 &&((TwoString2)obj).s1.equals(s1);
	}
	private static RandomGenerator.String gen = new RandomGenerator.String();
	public static Generator<TwoString2> generator() 
	{
		return new Generator<TwoString2>() 
		{
			public TwoString2 next() 
			{
				return new TwoString2(gen.next(), gen.next());
			}
		};	
	}
}
public class E41_HashedComparable
{
	public static void main(String[] args) 
	{
		HashSet<TwoString2> hs = new HashSet<TwoString2>();
		HashMap<TwoString2,Integer> hm = new HashMap<TwoString2,Integer>();
		Generator<TwoString2> gen = TwoString2.generator();
		hs.addAll(CollectionData.list(gen, 8));
		for(int i = 0; i < 8; i++)
			hm.put(gen.next(), i);
		System.out.println("hs = " + hs);
		System.out.println("hm = " + hm);
		
		
	}
}