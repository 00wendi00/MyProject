/**
 * 文件名：Ex19.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-27
 */
package 第十六章数组;



/**
 * @author 张文迪
 * 类名：Ex19
 * 类说明：
 */
import java.util.*;
import static net.mindview.util.Print.*;

class A19 implements Comparable<A19>
{
	protected int x;
	A19(int x) { this.x = x; }
	public boolean equals(Object b) 
	{
		System.out.println(b.getClass().getSimpleName());
		return (b.getClass().getSimpleName() == "A19" 
			&& this.x == ((A19)b).x) ? true : false;
	}

	public int compareTo(A19 b) 
	{
		return (this.x < b.x ? -1 : (this.x == b.x ? 0 : 1));
	}
	
}

public class Ex19 
{
	public static void main(String[] args) 
	{
		A19[] a1 = new A19[4];  //{ new A19(1), new A19(2), new A19(3) };
		a1[0] = new A19(2);
		a1[1] = new A19(3);
		a1[2] = new A19(1);
		a1[3] = new A19(3);     //Index: 0, 第十六章数组.A19@61de33   观察下面的 输出，看地址，看 index，真的很神奇啊 ~~~~
		A19[] a2 = { new A19(1), new A19(2), new A19(3) };
		print(Arrays.toString(a1));
		print(Arrays.toString(a2));
		print(Arrays.equals(a1, a2));
		
		Arrays.sort(a1);
		int index = Arrays.binarySearch(a1, new A19(1));
		System.out.println("Index: " + index + ", " + a1[index]);
	}
}
