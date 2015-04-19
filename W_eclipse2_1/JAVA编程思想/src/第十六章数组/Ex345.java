/**
 * 文件名：Ex3.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-26
 */
package 第十六章数组;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 张文迪
 * 类名：Ex34
 * 类说明：练习3~4~5
 */
public class Ex345
{
	static Double[][][] haha3(int k,int p,int q)
	{
		Double[][][] d = new Double[k][p][q];
		return d;
	}
	static void haha33(Double[][][] doubles)
	{
		System.out.println(Arrays.deepToString(doubles));
	}
	static A[][] haha5(int p,int q)
	{
		A[][] a = new A[p][q] ;
		return a;
	}
	static void haha55(A[][] a)
	{
		System.out.println(Arrays.deepToString(a));
	}
	public static void main(String args[])
	{
		Random random = new Random(47);
		Double[][][] d = haha3(2,3,1);
		for(int i= 0;i<d.length;i++)
			for(int m = 0;m<d[i].length;m++)
				for(int j=0;j<d[i][i].length;j++)
					d[i][m][j] = random.nextDouble();
		haha33(d);
		
		A[][] a = new A[2][3];
		haha55(a);
	}
}
