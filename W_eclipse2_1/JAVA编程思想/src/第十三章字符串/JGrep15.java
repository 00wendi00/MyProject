/**
 * 文件名：JGrep15.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-16
 */
package 第十三章字符串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 张文迪
 * 类名：JGrep15
 * 类说明： 练习15~
 */

public class JGrep15  
{
	public static void main(String[] args) throws Exception 
	{
		if(args.length < 3) 
		{
			System.out.println("Usage: java JGrep file regex flag");
			System.exit(0);
		}
		int flag = 0;
		if(args[2].equals("Pattern.CASE_INSENSITIVE")) 
			flag = Pattern.CASE_INSENSITIVE;
		else if(args[2].equals("Pattern.CANON_EQ"))
			flag = Pattern.CANON_EQ;
		else if(args[2].equals("Pattern.COMMENTS"))
			flag = Pattern.COMMENTS;
		else if(args[2].equals("Pattern.DOTALL"))
			flag = Pattern.DOTALL;
		else if(args[2].equals("Pattern.LITERAL"))
			flag = Pattern.LITERAL;
		else if(args[2].equals("Pattern.MULTILINE"))
			flag = Pattern.MULTILINE;
		else if(args[2].equals("Pattern.UNICODE_CASE"))
			flag = Pattern.UNICODE_CASE;
		else if(args[2].equals("Pattern.UNIX_LINES"))
			flag = Pattern.UNIX_LINES;
		Pattern p = Pattern.compile(args[1], flag);
		// Iterate through the lines of the input file:
		int index = 0;
		Matcher m = p.matcher(""); // creates empty Matcher object
		for(String line : new TextFile(args[0])) 
		{
			m.reset(line);
			while(m.find())
				System.out.println(index++ + ": " + m.group() + ": " + m.start());
		}
	}
}
