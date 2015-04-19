/**
 * 文件名：Sequence2.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-1
 */
package 第十一章.持有对象;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 张文迪
 * 类名：Sequence2
 * 类说明： 练习9：  Iterator  ~~~
 */

public class Sequence9 
{
	private ArrayList<Object> items = new ArrayList<Object>();
	public void add(Object x) 
	{
		items.add(x);
	}
	public Iterator iterator() 
	{
		return items.iterator();
	}
	public static void main(String[] args) 
	{
		Sequence9 sequence = new Sequence9();
		for(int i = 0; i < 10; i++)
			sequence.add(Integer.toString(i));
		Iterator it = sequence.iterator();
		
		while(it.hasNext()) 
		{			
			System.out.print(it.next() + " ");
		}
		
		display(sequence.iterator()); //+++
	}	
	//+++
	private static void display(Iterator iterator)
	{
		while(iterator.hasNext())
		{
			Object ob = iterator.next();
			System.out.println(ob);
		}
	}
}
