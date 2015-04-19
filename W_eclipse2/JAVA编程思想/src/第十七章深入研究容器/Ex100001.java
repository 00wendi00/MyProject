/**
 * 文件名：Ex10.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-28
 */
package 第十七章深入研究容器;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author 张文迪
 * 类名：Ex10
 * 类说明：
 */
class MyClass10
{
	
}
public class Ex100001
{
	public static void main(String args[])
	{
		SortedSet<MyClass10> ss = new TreeSet<MyClass10>();
		LinkedList<MyClass10> ll = new LinkedList<MyClass10>();
		MyClass10[] a = {new MyClass10(),new MyClass10()};
		ll.add(a[0]);
		ll.add(a[0]);
		ll.add(a[1]);
		ll.add(a[1]);
		ll.add(a[1]);
		System.out.println(ll);   // 看地址~~
		ss.add(ll.get(0));
		//ss.add(ll.get(1));
		//ss.add(ll.get(2));
		//ss.add(ll.get(3));
		System.out.println(ss);
	}
}
