/**
 * 文件名：JGrep16.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-16
 */
package 第十三章字符串;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 张文迪
 * 类名：JGrep16
 * 类说明： 练习16~~~~~
 */

public class JGrep16  
{
	public static void main(String[] args) throws Exception 
	{
		if(args.length < 2) 
		{
			System.out.println("Usage: java JGrep (file or directory) regex");
			System.exit(0);
		}
		Pattern p = Pattern.compile(args[1]);
		Matcher d = Pattern.compile("\\w+\\.{1}\\w+").matcher(args[0]);
		if(d.find()) 
		{
			System.out.println("File: " + args[0]);
			// Iterate through the lines of the input file:
			int index = 0;
			Matcher m = p.matcher(""); // creates emtpy Matcher object
			for(String line : new TextFile(args[0])) 
			{
				m.reset(line);
				while(m.find())
					System.out.println(index++ + ": " + m.group() + ": " + m.start());
			}
		}		
		Matcher e = Pattern.compile("^\\.{1}$").matcher(args[0]);
		if(e.find())
 		{
			File[] files = new File(args[0]).listFiles();
			System.out.println("root dir of files: " + Arrays.asList(files));
			// Iterate through the lines of each file in directory:
			for(File f : files) 
			{
				if(f.getName().matches("\\w+\\.{1}\\w+")) 
				{
					System.out.println(f.getName() + ":");
					int index = 0;
					Matcher m = p.matcher(""); // creates emtpy Matcher object
					for(String line : new TextFile(f.getName()))
					{
						m.reset(line);
						while(m.find())
							System.out.println(index++ + ": " + 
								m.group() + ": " + m.start());
					}
				}
				System.out.println();
			}
		}
		d.reset();
		e.reset();
		if(!(d.find() || e.find())) 
		{
			if(new File(args[0]).listFiles() == null) 
			{ 
				System.out.println("no such directory: " + args[0]);
				System.exit(0); 
			}
			File[] files = new File(args[0]).listFiles();
			System.out.println(args[0] + ": subdir of files: " + Arrays.asList(files));
			// Iterate through the lines of each file in directory:
			for(File f : files) 
			{
				int index = 0;
				Matcher m = p.matcher(""); // creates emtpy Matcher object
				for(String line : new TextFile(args[0] + "\\" + f.getName())) 
				{
					m.reset(line);
					while(m.find())
						System.out.println(index++ + ": " + 
							m.group() + ": " + m.start());
				}
				System.out.println();
			}
		}
	}
}
