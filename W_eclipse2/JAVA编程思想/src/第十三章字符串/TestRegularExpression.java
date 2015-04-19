/**
 * 文件名：TestRegularExpression.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-16
 */
package 第十三章字符串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 张文迪
 * 类名：TestRegularExpression
 * 类说明：p300例子~~控制台输入~~~
 */
public class TestRegularExpression
{
	public static void main(String[] args)
	{
		if(args.length<2)
		{
			System.out.println("Usage:\njava TestRegularExpression" + "characterSequence regularExpression+");
			System.exit(0);
		}
		System.out.println("Input:\""+args[0]+"\"");
		for(String arg:args)
		{
			System.out.println("222222Regular expression:\""+arg+"\"");
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			while(m.find())
			{
				System.out.println("111111"+"Match\""+m.group()+"\"at positions"+m.start()+"-"+(m.end()-1));
			}
		}
	}
}
