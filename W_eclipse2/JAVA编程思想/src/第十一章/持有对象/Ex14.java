/**
 * 文件名：Ex14.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-8
 */
package 第十一章.持有对象;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author 张文迪
 * 类名：Ex14
 * 类说明：  调用静态方法 addMiddle +++ 插入
 */
public class Ex14 
{
	static void addMiddle(LinkedList<Integer> l, Integer[] ia) 
	{
		for(Integer i : ia) 
		{
			ListIterator<Integer> it = 
				l.listIterator((l.size())/2);
			it.add(i);
			System.out.println(l);
		}
	}
	public static void main(String[] args) 
	{
		LinkedList<Integer> li = new LinkedList<Integer>();
		Integer[] x = {0, 1, 2, 3, 4, 5, 6, 7};
		Ex14.addMiddle(li, x);
	}	
}

