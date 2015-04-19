/**
 * 文件名：Ex1.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-28
 */
package 第十七章深入研究容器;

import java.util.*;
import net.mindview.util.*;

/**
 * @author 张文迪
 * 类名：Ex1
 * 类说明： shuffle()使用默认随机源对指定列表进行置换~ ;  sort()根据元素的自然顺序 对指定列表按升序进行排序  ~~  132...ABC...abc...
 */
public class Ex1 
{
	public static void main(String[] args) 
	{
		List<String> al = new ArrayList<String>();
		List<String> ll = new LinkedList<String>();
		for(int i = 0; i < Countries.DATA.length; i++) 
		{
			al.add(Countries.DATA[i][0]);
			ll.add(Countries.DATA[i][1]);
		}
		System.out.println("Countries: " + al);
		System.out.println("Capitals: " + ll);
		Collections.sort(al);
		Collections.sort(ll); // abcdefg~~~
		System.out.println("Countries: " + al);
		System.out.println("Capitals: " + ll);
		for(int i = 0; i < 2; i++) 
		{
			Collections.shuffle(al);
			Collections.shuffle(ll);
			System.out.println("Countries " + i + ": " + al);
			System.out.println("Capitals " + i + ": " + ll);
		}
		List<String> al2 = new ArrayList<String>();
		List<String> ll2 = new LinkedList<String>();
		for(int i = 0; i < 4; i++) 
		{
			al2.add(Countries.DATA[i][0]);
			ll2.add(Countries.DATA[i][0]);
		}
		for(int i = 0; i < 3; i++) 
		{
			Collections.shuffle(al2);
			Collections.shuffle(ll2);
			System.out.println("Countries " + i + ": " + al2);
			System.out.println("Capitals " + i + ": " + ll2);
			Collections.sort(al2);
			Collections.sort(ll2);
			System.out.println("Countries " + i + ": " + al2);
			System.out.println("Capitals " + i + ": " + ll2);
		}
	}
}
