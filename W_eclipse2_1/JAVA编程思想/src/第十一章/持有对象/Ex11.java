/**
 * 文件名：Ex11.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-8
 */
package 第十一章.持有对象;

import java.util.*;


/**
 * @author 张文迪
 * 类名：Ex11
 * 类说明：   Arrays.asList(11, 22, 33)~~~~~~
 */
public class Ex11 {
	public static void printAny(Collection c) 
	{
		Iterator it = c.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
	}
	public static void main(String[] args) 
	{
		ArrayList<Integer> al = 
			new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		LinkedList<Character> ll =
			new LinkedList<Character>(Arrays.asList('a', 'b', 'c'));	
		HashSet<Float> hs = 
			new HashSet<Float>(Arrays.asList(1.1f, 2.2f, 3.3f));
		TreeSet<Double> ts =
			new TreeSet<Double>(Arrays.asList(1.11, 2.22, 3.33));
		LinkedHashSet<Integer> lhs =
			new LinkedHashSet<Integer>(Arrays.asList(11, 22, 33));
		printAny(al);
		printAny(ll);
		printAny(hs);
		printAny(ts);
		printAny(lhs);
	}
}