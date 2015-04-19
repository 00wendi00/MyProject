/**
 * 文件名：StartEnd.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-16
 */
package 第十三章字符串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 张文迪
 * 类名：StartEnd
 * 类说明：练习13： 正则表达式~我尼玛也是醉了         \\w*ere\\w*","\\w*ever","T\\w+","The.*
 */
public class StartEnd
{
	public static String input = 
		"Twas brillig, and the slithy toves\n" +
		"Did gyre and gimble in the wabe.\n" +
		"All mimsy were the borogoves,\n" +
		"And the mome raths outgrabe.\n\n" +
		"Beware the Jabberwock, my son,\n" +
		"The jaws that bite, the claws that catch,\n" +
		"Beware the Jubjub bird, and shun\n" +
		"The frumious Bandersnatch.";
	private static class Display
	{
		private boolean regexPrinted = false;
		private String regex;
		Display(String regex)
		{
			this.regex = regex;
		}
		void display(String message)
		{
			if(!regexPrinted)
			{
				System.out.println(regex);
				regexPrinted = true;
			}
			System.out.println(message);
		}
	}
	static void examine(String s,String regex)
	{
		Display d = new Display(regex);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		while(m.find())
			d.display("find() '" + m.group()+"' start = "+m.start()+" end = "+m.end());
	    if(m.lookingAt())
	    	d.display("lookingAt() start ="+m.start()+" end = "+m.end());
	    if(m.matches())
	    	d.display("matches() start = "+m.start()+" end = "+m.end());
	}
	public static void main(String args[])
	{
		for(String in:input.split("\n"))
		{
			System.out.println("input :"+in);
			for(String regex:new String[]{"\\w*ere\\w*","\\w*ever","T\\w+","The.*"})
				examine(in, regex);
		}
	}
}

