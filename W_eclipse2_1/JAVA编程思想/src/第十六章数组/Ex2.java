/**
 * 文件名：Ex2.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-26
 */
package 第十六章数组;

import java.util.Arrays;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author 张文迪
 * 类名：Ex2
 * 类说明：
 */
public class Ex2
{
	public static A[] heihei(int k)
	{
		A[] a = new A[k];
		for(int i =0;i<k;i++)
			a[i] = new A();
		return a;		
	}
	public static void main(String args[])
	{
		System.out.println(Arrays.toString(heihei(5)));
	}
}
