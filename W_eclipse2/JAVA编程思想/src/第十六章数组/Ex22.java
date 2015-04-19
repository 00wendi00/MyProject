/**
 * 文件名：Ex22.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-27
 */
package 第十六章数组;

/**
 * @author 张文迪
 * 类名：Ex22
 * 类说明：在未排序的数组上 执行 binarySearch()方法的结果是不可预知的；
 */
import java.util.*;
import net.mindview.util.*;

public class Ex22 
{
	private static Random r = new Random();
	public static void main(String[] args) 
	{
		int[] ia = 
			ConvertTo.primitive(Generated.array(new Integer[20],new RandomGenerator.Integer(10)));
		System.out.println(Arrays.toString(ia));
		for(int i = 0; i < 10; i++) 
		{
			int index = Arrays.binarySearch(ia, i);
			if(index < 0) System.out.println(i + " not found");
			else
			System.out.println("Index: " + index + ", " + i);
		}
		System.out.println("sort");
		Arrays.sort(ia);
		System.out.println(Arrays.toString(ia));
		for(int i = 0; i < 10; i++) 
		{
			int index = Arrays.binarySearch(ia, i);
			if(index < 0) System.out.println(i + " not found");
			else
			System.out.println("Index: " + index + ", " + i);
		}		
	}
}
