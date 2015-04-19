/**
 * 文件名：Ex17.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-16
 */
package 第十三章字符串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 张文迪
 * 类名：Ex17
 * 类说明：
 */
public class Ex17  
{
	public static void main(String[] args) throws Exception 
	{
		if(args.length < 1) 
		{
			System.out.println("Usage: fileName");
			System.exit(0);
		}
		Pattern p = Pattern.compile("(//\\s.+)|(/\\*\\s+.+)|(\\*\\s+.+)");//注释~~//,/*
				  //Pattern.compile("\".*\"");  //普通字符串
		// Iterate through the lines of the input file:
		int index = 0;
		Matcher m = p.matcher(""); // creates emtpy Matcher object
		System.out.println(args[0] + " comments: ");
		for(String line : new TextFile(args[0])) 
		{
			m.reset(line);
			while(m.find())
				System.out.println(index++ + ": " + m.group());
			System.out.format(format, args);
		}
	}
}


/*练习19：所有类 的名字~~~
 * public class Ex19  
 * {
	public static void main(String[] args) throws Exception
	{
		if(args.length < 1) 
		{
			System.out.println("Usage: fileName");
			System.exit(0);
		}		
		// we want all class names:
		Pattern p = Pattern.compile("class \\w+\\s+");
		// not including those in comment lines:
		Pattern q = Pattern.compile("^(//|/\\*|\\*)");
		System.out.println("classes in " + args[0] + ":");
		// Iterate through the lines of the input file:
		int index = 0;
		Matcher m = p.matcher(""); // creates emtpy Matcher object
		Matcher n = q.matcher("");
		for(String line : new TextFile(args[0])) 
		{
			m.reset(line);
			n.reset(line);
			while(m.find() && !n.find())
				System.out.println(index++ + ": " + m.group());
		}
	}
}
 * 
 */
