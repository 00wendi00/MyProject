/**
 * 文件名：Ex100002.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-28
 */
package 第十七章深入研究容器;

/**
 * @author 张文迪
 * 类名：Ex100002
 * 类说明：  定义自己的SortedSet！！！！！！！！！！！ 书上的例子意义非凡
 */
import java.util.*;
import static net.mindview.util.Print.*;

class SortedSet10<E> extends LinkedList<E> 
{
	int compare(E e1, E e2) 
	{
		int c = e1.hashCode() - e2.hashCode();
		return (c < 0) ? -1 : ((c == 0) ? 0 : 1);
	}
	public boolean add(E e) 
	{
		if(!this.contains(e)) 
		{
			Iterator<E> it = this.iterator();
			int index = 0;
			while(it.hasNext()) 
			{
				if(compare(it.next(), e) < 1) 
					index++;
			}
			add(index, e);
			return true;
		}
		return false;
	}
}

class T {}

public class Ex100002 
{
	public static void main(String[] args) 
	{
		SortedSet10<T> ss = new SortedSet10<T>();
		ss.add(new T());
		ss.add(new T());
		ss.add(new T());	
		ss.add(new T());
		print(ss);
		SortedSet10<Integer> ss2 = new SortedSet10<Integer>();
		ss2.add(6);
		ss2.add(8);
		ss2.add(2);
		ss2.add(4);
		ss2.add(2);
		ss2.add(8);
		print(ss2);
		SortedSet10<String> ss3 = new SortedSet10<String>();
		ss3.add("three");
		ss3.add("three");
		ss3.add("seven");
		ss3.add("hi");
		ss3.add("two");
		ss3.add("one");
		print(ss3);
	}
}