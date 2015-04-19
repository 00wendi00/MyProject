/**
 * 文件名：Ex6.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author 张文迪
 * 类名：Ex6
 * 类说明：
 */
import java.io.*;
import java.text.*;
import java.util.*;
import net.mindview.util.*;

public class Ex6 
{
	public static void main(String[] args) 
	{
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
		if(args.length != 2) 
		{
			System.err.println("Usage: java E06_ProcessFiles3 path date");
			return;
		}
		long tmp = 0;
		try {
			df.setLenient(false);//指定日期/时间解析是否不严格。进行不严格解析时，解析程序可以使用启发式的方法来解释与此对象的格式不精确匹配的输入。
								//进行严格解析时，输入必须匹配此对象的格式
							   //为 true 时，解析过程是不严格的
			tmp = df.parse(args[1]).getTime();//从给定字符串的开始解析文本，以生成一个日期。该方法不使用给定字符串的整个文本。
		} 
		catch(ParseException pe) 
		{
			pe.printStackTrace();  //将此 throwable 及其追踪输出至标准错误流
			return;
		}
		final long modTime = tmp;
		new ProcessFiles(new ProcessFiles.Strategy() 
		{
			public void process(File file) 
			{
				if(modTime < file.lastModified())
					System.out.println(file);
			}
		}, "java").start(new String[] {args[0]});
	}
}
