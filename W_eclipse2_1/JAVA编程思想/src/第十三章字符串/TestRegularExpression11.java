/**
 * 文件名：Ex11.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-16
 */
package 第十三章字符串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 张文迪
 * 类名：Ex11
 * 类说明：(?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b   //   ！真个表达式。aeiou开头或者结尾的
 */ 
public class TestRegularExpression11 
{
	public static void main(String[] args) 
	{
		if(args.length < 2) 
		{
			System.out.println("Usage:\njava TestRegularExpression " + 
				"characterSequence regularExpression+");
			System.exit(0);  
		}
		System.out.println("Input: \"" + args[0] + "\"");
		for(String arg : args) 
		{
			System.out.println("Regular expression: \"" + arg + "\"");
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			if(!m.find()) 
			  	System.out.println("No match found for " + "\"" + arg + "\"");
			m.reset();
			while(m.find()) 
			{
				System.out.println("Match \"" + m.group() + "\" at position " +
					m.start() + ((m.end() - m.start() < 2) ? "" :  ("-" + (m.end() - 1))));
			}
		}
	}
}
