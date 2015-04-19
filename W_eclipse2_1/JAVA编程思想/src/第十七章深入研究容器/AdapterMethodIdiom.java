/**
 * 文件名：ReversibleArrayList.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-29
 */
package 第十七章深入研究容器;

import java.util.*;

/**
 * @author 张文迪
 * 类名：ReversibleArrayList
 * 类说明：通过适配器方法 ，反向 迭代器~~  
 */
class ReversibleArrayList<T> extends ArrayList<T>
{
	public ReversibleArrayList(Collection<T> c) {super(c);}
	public Iterable<T> reversed()
	{
		return new Iterable<T>()
		{
			public Iterator<T> iterator()
			{
				return new Iterator<T>()
				{
					int current = size()-1;
					public boolean hasNext()
					{
						return current>-1;
					}

					public T next()   
					{
						return get(current--);
					}
					public void remove()
					{
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}
public class AdapterMethodIdiom
{
	public static void main(String args[])
	{
		ReversibleArrayList<String> ral = 
			new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
		for(String s:ral)
			System.out.print(s+" ");
		System.out.println();
		for(String s: ral.reversed())
			System.out.print(s+" ");
	}
	
}
