/**
 * 文件名：Ex23.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-27
 */
package 第十六章数组;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * @author 张文迪
 * 类名：Ex23
 * 类说明：排序必须是升序 的，或者 按照自己的方式(顺序一样的)排序，查找
 *	             如果没找到，则 返回负数。
 */
public class Ex23
{
	public static void main(String args[])
	{
		Integer[] integers = new Integer[10];
		Random random = new Random();
		for(int i =0;i<10;i++)
			integers[i] = (Integer)random.nextInt(10);
		System.out.println(Arrays.toString(integers));
		int index1 = Arrays.binarySearch(integers, 3);
		System.out.println(index1);
		
		Arrays.sort(integers);
		System.out.println(Arrays.toString(integers));
		int index2 = Arrays.binarySearch(integers, 3);
		System.out.println(index2);  // 排序必须是升序 的，或者 按照自己的方式(顺序一样的)排序，查找
									//  如果没找到，则 返回负数。
		
		Arrays.sort(integers,Collections.reverseOrder());
		System.out.println(Arrays.toString(integers));	
		int index3 = Arrays.binarySearch(integers, 3);
		System.out.println(index3);
	}
}
