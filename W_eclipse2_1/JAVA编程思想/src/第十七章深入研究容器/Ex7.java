/**
 * 文件名：Ex7.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-28
 */
package 第十七章深入研究容器;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import net.mindview.util.Countries;

/**
 * @author 张文迪
 * 类名：Ex7
 * 类说明：      // 利用Iterator 和   ListIterator，改变了底层的数据结构~~~ al变了 ，我也是醉了 ！！！！！！！！！！！！！ 
 */
public class Ex7
{
	public static void main(String args[])
	{
		ArrayList<String>  al = new ArrayList<String>();
		LinkedList<String> kl = new LinkedList<String>();
		al.addAll(Countries.names(6));
		kl.addAll(Countries.names(5));
		System.out.println(al);
		System.out.println(kl);
		
		Iterator<String> at = al.iterator();
		Iterator<String> kt = kl.iterator();
		while(at.hasNext())
			System.out.print(at.next()+" ");
		System.out.println();
		while(kt.hasNext())
			System.out.print(kt.next()+" ");
		System.out.println();
		
		ListIterator lat = al.listIterator();
		ListIterator lkt = kl.listIterator();

		while(lkt.hasNext())
		{
			lkt.next();
		}
		while(lat.hasNext())
		{
			lat.next();
		}
		while(lkt.hasPrevious())
		{
			lat.add(lkt.previous());
			lat.previous();
			lat.previous();
		}
		System.out.println(al); 
		       // 利用Iterator 和   ListIterator，改变了底层的数据结构~~~ al变了 ，我也是醉了 ！！！！！！！！！！！！！
	}
}
