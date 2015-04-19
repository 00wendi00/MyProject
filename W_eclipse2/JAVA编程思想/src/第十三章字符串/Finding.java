/**
 * 文件名：Finding.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-16
 */
package 第十三章字符串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 张文迪
 * 类名：Finding
 * 类说明：
 */
public class Finding
{
	public static void main(String args[])
	{
		Matcher m = Pattern.compile("\\w+").matcher("Evening is full of the linnet's wings");
		while(m.find())
			System.out.print(m.group()+" ");
		System.out.println();
		int i =0;
		while(m.find(i))
		{
			//System.out.print(i+" ");
			System.out.print(m.group()+" ");
			i++;
		}
	}
}
