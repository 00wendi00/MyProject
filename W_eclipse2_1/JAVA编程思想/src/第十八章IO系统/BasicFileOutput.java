/**
 * 文件名：BasicFileOutput.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @author 张文迪
 * 类名：BasicFileOutput
 * 类说明：基本文件的 输出~
 */
public class BasicFileOutput
{
	static String file  = "C:/Users/张文迪/Desktop/新建文件夹1/1.java";
	public static void main(String args[]) throws IOException
	{
		// 从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
		BufferedReader in = new BufferedReader(
				new StringReader(BufferedInputFile.read("C:/Users/张文迪/Desktop/新建文件夹1/1.java")));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
										// 用bufferedWriter 包装起来用以缓冲输出~~
		PrintWriter out = new PrintWriter(file);
		int lineCount = 1;
		String s;
		while((s=in.readLine())!= null)
			out.println(lineCount++ +": "+s );
		out.close();
		System.out.println(BufferedInputFile.read(file));
	}                             
}
