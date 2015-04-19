/**
 * 文件名：Splitting8.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-14
 */
package 第十三章字符串;

import java.util.Arrays;

/**
 * @author 张文迪
 * 类名：Splitting8
 * 类说明：Arrays.toString(knights.split(regex))
 */
public class Splitting8 
{
	public static String knights =
		"Then, when you have found the shrubbery, you must " +
		"cut down the mightiest tree in the forest... " +
		"with... a herring!";
	public static void split(String regex) 
	{
		System.out.println(Arrays.toString(knights.split(regex)));
	}
	public static void main(String[] args) 
	{
		split("the|you");
	}
}