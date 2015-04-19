/**
 * 文件名：CompType.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-27
 */
package 第十六章数组;

import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

/**
 * @author 张文迪
 * 类名：CompType
 * 类说明：练习21 ：数组元素的比较，实现java.lang.Comparable 接口~~~~~~用Collections 中的reverseOrder()方法产生Comparator ,反顺序
 */
public class CompType implements Comparable<CompType>  //！！
{
	int i,j;
	private static int count = 1;
	public CompType(int n1,int n2)
	{
		i = n1;
		j = n2;
	}
	public String toString()
	{
		String result = "[i=" + i + ",j="+j+"]";
		if(count++%3 == 0)
			result +="\n";
		return result;
	}
	public int compareTo(CompType rv)
	{
		return (i<rv.i ?  -1:(i==rv.i ? 0:1));
	}
	private static Random r = new Random(47);
	public static Generator<CompType> generator()
	{
		return new Generator<CompType>()
		{
			public CompType next()
			{
				return new CompType(r.nextInt(80), r.nextInt(70));
			}
		};
	}
	public static void main(String args[])
	{
		CompType[] a = Generated.array(new CompType[12], generator());
		print("before sorting:");
		print(Arrays.toString(a));
		Arrays.sort(a);
		print("after sorting:");
		print(Arrays.toString(a));
		
		print("after sorting222:");
		Arrays.sort(a,Collections.reverseOrder());// ~！！！！！！！！！！！！！！！！
		print(Arrays.toString(a));
	}
}
