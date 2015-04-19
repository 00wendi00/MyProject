/**
 * 文件名：Ex32.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-26
 */
package 第十六章数组;

import java.util.Arrays;

/**
 * @author 张文迪
 * 类名：Ex32
 * 类说明：
 */
public class Ex32
{
	static double[][] createArray(int size1, int size2, double start, double end) 
	{
		if(!(start < end)) 
		{
			System.out.println("Start must be less than end");
			return null;
		}
		if((size1 < 1) || (size2 < 1)) 
		{
			System.out.println("Size must be > 0");
			return null;
		}
		double[][] result = new double[size1][size2];
		result[0] = new double[size2];
		for(int j = 0; j < size2; j++)
			result[0][j] = (start + ((double)j/(size2 - 1)) * (end - start))???;
		if(size1 == 1) 	return result;
		else 
		for(int i = 1; i < size1; i++) 
		{
			result[i] = new double[size2];
			for(int j = 0; j < size2; j++) 
			{
			   	 result[i][j] = start + 
				((double)j/(size2 - 1))*(((double)j + (double)i)/(size2 - 1 + i)) * (end - start);
			}
		}
		return result;
	} 
	static void printArray(double[][] da) 
	{
		System.out.println(Arrays.deepToString(da));
	}
	public static void main(String[] args) 
	{
		printArray(createArray(0,2,4,5));
		printArray(createArray(2,3,5,4));
		printArray(createArray(1,2,5,10));
		printArray(createArray(2,2,5,10));
		printArray(createArray(3,3,5,10));
		printArray(createArray(3,5,10,20));
	}
}