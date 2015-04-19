/**
 * 文件名：Ex12.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-16
 */
package 第十三章字符串;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 张文迪
 * 类名：Ex12
 * 类说明：(^[a-z]|\\s+[a-z])\\w+    //??????????
 * 		Pattern:指定为字符串的正则表达式必须首先被编译为此类的实例
 */
public class Groups12 
{
	static public final String POEM =
	"Twas brillig, and the slithy toves\n" +
	"Did gyre and gimble in the wabe.\n" +
	"All mimsy were the borogoves,\n" +
	"And the mome raths outgrabe.\n\n" +
	"Beware the Jabberwock, my son,\n" +
	"The jaws that bite, the claws that catch,\n" +
	"Beware the Jubjub bird, and shun\n" +
	"The frumious Bandersnatch.";
	public static void main(String[] args) 
	{
		Matcher m = Pattern.compile("(\\s+[a-z])\\w+").matcher(POEM);//  ??????
		Set<String> words = new TreeSet<String>();
		while(m.find()) 
		{
			words.add(m.group());
		}
		System.out.println("Number of unique non-cap words = " + words.size());
		System.out.println(words);
	}
}
