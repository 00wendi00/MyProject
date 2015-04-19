/**
 * 文件名：Ex12.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-8
 */
package 第十一章.持有对象;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author 张文迪
 * 类名：Ex12
 * 类说明：
 */
public class Ex12 {
	public static void main(String[] args) {
		List<Integer> li1 = 
			new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4));
		List<Integer> li2 = 
			new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8, 9));
		ListIterator<Integer> it1 = li1.listIterator();
		ListIterator<Integer> it2 = li2.listIterator();
		System.out.println("li1: " + li1);
		System.out.println("li2: " + li2);
		// move it1 to end:
		while(it1.hasNext())
			it1.next();
		// now use it2 to re-set li2:
		while(it2.hasNext()) 
		{	
			it2.next();		
			it2.set(it1.previous());
		}
		System.out.println("li1: " + li1);
		System.out.println("li2: " + li2);
		
	}
}

