/**
 * 文件名：CountingIntegerList.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-28
 */
package 第十七章深入研究容器;

import java.util.AbstractList;

/**
 * @author 张文迪
 * 类名：CountingIntegerList
 * 类说明：  认识  AbstractList.get()  .size();    
 */
public class CountingIntegerList extends AbstractList<Integer>
{
	private int size ;
	public CountingIntegerList(int size)
	{
		this.size = size <0 ? 0:size;
	}
	public Integer get(int index)
	{		
		return Integer.valueOf(index);
	}
	public int size() {return size;}
	public static void main(String args[])
	{
		System.out.println(new CountingIntegerList(10));
	}
}
