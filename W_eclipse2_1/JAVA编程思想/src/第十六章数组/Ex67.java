/**
 * 文件名：Ex6.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-26
 */
package 第十六章数组;

import java.util.Arrays;

/**
 * @author 张文迪
 * 类名：Ex6
 * 类说明：练习 6~7
 */
public class Ex67
{
	static A[][][] haha6(int p,int q,int k)
	{
		A[][][] a = new A[p][q][k];
		for(int i = 0;i<p;i++)
		   for(int u =0;u<q;u++)
			   for(int y=0;y<k;y++)
				   a[i][u][y] = new A();
		return a;
	}
	public static void main(String args[])
	{
		System.out.println(Arrays.deepToString(haha6(2,2,2)));
	}
}
