/**
 * 文件名：Ex20.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-27
 */
package 第十六章数组;

import java.util.Arrays;
import static net.mindview.util.Print.*;
/**
 * @author 张文迪
 * 类名：Ex20
 * 类说明：   多维数组中的deepToString()和deepEquals() +   Arrays.binarySearch(~,~)
 */
public class Ex20
{
	public static void main(String args[])
	{
		int[][] a = new int[3][4],
				b = new int[3][4];
		for(int i =0;i<3;i++)
			for(int p = 0;p<4;p++)
				a[i][p] = p+i;
		System.out.println(Arrays.deepToString(a));
		
		for(int i =0;i<3;i++)
			for(int p = 0;p<4;p++)
				b[i][p] = p+i;
		System.out.println(Arrays.deepEquals(a,b));
		
		
		int[][][] a1 = new int[4][3][2];
		int[][][] a2 = new int[4][3][2];
		print(Arrays.deepToString(a1));
		print(Arrays.deepEquals(a1, a2));
		A[][][] aa1 = new A[4][3][2];
		A[][][] aa2 = new A[4][3][2];
		print(Arrays.deepToString(aa1));
		print(Arrays.deepEquals(aa1, aa2));
		print(Arrays.deepEquals(a1, aa1));
		
		
		int[] k1 ={4,8,6,3,7};
		int[] k2 ={1,2,3,4,5};
		int index1 = Arrays.binarySearch(k1, 7);
		int index2 = Arrays.binarySearch(k2, 1);
		System.out.println(index1);
		System.out.println(index2);
		
	}
}
