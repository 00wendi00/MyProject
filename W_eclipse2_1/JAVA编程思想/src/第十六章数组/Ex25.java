/**
 * 文件名：Ex25.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-27
 */
package 第十六章数组;

import java.util.*;
import static net.mindview.util.Print.*;


/**
 * @author 张文迪
 * 类名：Ex25
 * 类说明：  绝好的例子~~~ListIterator  迭代     ~~~~用 hasPrevious 实现 反序
 */
class MyList extends ArrayList<Integer> 
{
	List myList = new ArrayList();
	MyList(List l) { myList = l; }
	@SuppressWarnings("unchecked")
	MyList getReversed() 
	{
		ListIterator lit = myList.listIterator(myList.size());
		List reverseMyList = new ArrayList();
		while(lit.hasPrevious()) 
		{
			reverseMyList.add(lit.previous());
		}
		return new MyList(reverseMyList);   //用 hasPrevious 实现 反序
	}
}

public class Ex25 
{
	public static void main(String[] args) 
	{
		List<Integer> aList = 
			new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		print(aList);
		print(aList.get(4));
		aList.add(new Integer(6));
		//aList.addAll(new ArrayList<Integer>(Arrays.asList(7,8)));
		aList.addAll(Arrays.asList(7,8));
		print(aList);
		print(aList.subList(2,4));
		MyList ml = new MyList(aList);
		print((ml.getReversed()).myList);
	}
}