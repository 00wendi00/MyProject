/**
 * 文件名：Ex14.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-26
 */
package 第十六章数组;

import java.util.Arrays;

import net.mindview.util.CountingGenerator;

/**
 * @author 张文迪
 * 类名：Ex14
 * 类说明：
 */
public class Ex14
{
	public static void main(String args[])
	{
		int[] i = new int[5];
		char[] c = new char[5];
		long[] l = new long[5];
		double[] d = new double[5];
		String[] s = new String[5];
		CountingGenerator.Integer ig = new CountingGenerator.Integer();
		CountingGenerator.Character cg = new CountingGenerator.Character();
		CountingGenerator.Long lg = new CountingGenerator.Long();
		CountingGenerator.Double  dg = new CountingGenerator.Double();
		CountingGenerator.String sg = new CountingGenerator.String();
		for(int k =0;k<5;k++)
		{
			i[k] = ig.next();
			c[k] = cg.next();
			l[k] = lg.next();
			d[k] = dg.next();
			s[k] = sg.next();
		}
		System.out.println(Arrays.toString(i));
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(l));
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.toString(s));
	}
}
