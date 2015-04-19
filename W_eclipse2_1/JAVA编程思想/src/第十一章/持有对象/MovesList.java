/**
 * 文件名：TestList.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-9-29
 */
package 第十一章.持有对象;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;


/**
 * @author 张文迪
 * 类名：TestList
 * 类说明：练习4： 数组--列表--输出
 */

public class MovesList
{
	int key = 0;
	public String next() {
		switch(key) {
			default:
			case 0 : key++; return "Snow White";
			case 1 : key++; return "Bashful";
			case 2 : key++; return "Doc";
			case 3 : key++; return "Dopey";
			case 4 : key++; return "Grumpy";
			case 5 : key++; return "Happy";
			case 6 : key++; return "Sleepy";
			case 7 : key = 0; return "Sneezy";			
		}
	} 
	public void fillA(String[] a)
	{
		for(int i = 0;i<a.length;i++)
			a[i] = next();
	}
    public Collection fill(Collection<String> c,int n)
    {
    	for(int i = 0; i < n; i++) 
    		c.add(next());
		return c;
    }
	
	
	public static void main(String args[])
	{
		MovesList gen = new MovesList();		
		String[] a = new String[10];
		gen.fillA(a);
		for(String s : a) System.out.print(s + ", ");
		System.out.println();
		System.out.println();
		System.out.println(gen.fill(new ArrayList<String>(), 10));
		System.out.println(gen.fill(new LinkedList<String>(), 10));
		System.out.println(gen.fill(new HashSet<String>(), 10));
		System.out.println(gen.fill(new LinkedHashSet<String>(), 10));
		System.out.println(gen.fill(new TreeSet<String>(), 10));
	}
}
