/**
 * 文件名：eX18.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-27
 */
package 第十六章数组;

import java.util.Arrays;

/**
 * @author 张文迪
 * 类名：eX18
 * 类说明：
 */
public class Ex18
{
	public static void main(String args[])
	{
		A[] a = new A[4];
		for(int i = 0;i<4;i++)
			a[i] = new A();
		System.out.println(Arrays.toString(a));
		
		A[] b = new A[5];
		System.arraycopy(a, 0, b, 1, a.length);
		System.out.println(Arrays.toString(b));
	}
}
