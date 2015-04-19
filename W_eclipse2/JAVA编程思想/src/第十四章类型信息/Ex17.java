/**
 * 文件名：Ex17.java
 * 项目-包：JAVA编程思想 - 第十四章类型信息
 * 作者：张文迪
 * 创建日期：2014-10-19
 */
package 第十四章类型信息;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 张文迪
 * 类名：Ex17
 * 类说明：字符串替换~~~
 */
public class Ex17
{
	public static void main(String args[])
	{
		String s = "native,final";
		System.out.println(s);
		Pattern p = Pattern.compile("(\\w+\\.)|\\s*final|\\s*native");
		Matcher m = p.matcher(s);		
		while(m.find())
		{
			System.out.println(m.start());
			System.out.println(m.end());
			System.out.println(m.group());
			System.out.println(m.replaceAll(""));
			//System.out.println(m.group());
		}
	}
}
