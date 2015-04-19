/**
 * 文件名：Ex9.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-28
 */
package 第十七章深入研究容器;

import java.util.TreeSet;

import net.mindview.util.RandomGenerator;

/**
 * @author 张文迪
 * 类名：Ex9
 * 类说明：TreeSet<String> ts = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER); //!!!
 */
public class Ex9 
{
	public static void main(String[] args) 
	{
		TreeSet<String> ts = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);  
		                                       //一个对 String 对象进行排序的 Comparator，作用与 compareToIgnoreCase 相同
		RandomGenerator.String rgs = new RandomGenerator.String(5);
		for(int i = 0; i < 8; i++) 
		{
			ts.add(rgs.next());
		}
		System.out.println(ts);
	}
}
