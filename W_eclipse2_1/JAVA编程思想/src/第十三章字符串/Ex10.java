/**
 * 文件名：Ex10.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-16
 */
package 第十三章字符串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 张文迪
 * 类名：Ex10
 * 类说明：
 */
public class Ex10
{
	private static String s = "Java now has regular expressions";
	private static String k[] = {"^java","\breg.*","s?","s*","s+","s{4}","s{0,3}","Java"};
	public static void main(String args[])
	{
		for(String k1:k)
		{
			Pattern p = Pattern.compile(k1);
			Matcher m = p.matcher(s);
			System.out.println(m.matches());
		}
	}
}
