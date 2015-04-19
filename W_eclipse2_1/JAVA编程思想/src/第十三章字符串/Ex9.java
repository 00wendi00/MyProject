/**
 * 文件名：Ex9.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-14
 */
package 第十三章字符串;

/**
 * @author 张文迪
 * 类名：Ex9
 * 类说明：replaceAll("[aeiouAEIOU]", "_")
 */
public class Ex9
{
	public static String knights =
		"Then, when you have found the shrubbery, you must " +
		"cut down the mightiest tree in the forest... " +
		"with... a herring!";
	public static void main(String[] args) 
	{
		System.out.println(knights.replaceAll("[aeiouAEIOU]", "_"));
	}
}
