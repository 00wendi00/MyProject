/**
 * 文件名：Ex14.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 张文迪
 * 类名：Ex14
 * 类说明： 测试  有缓冲/无缓冲 的I/O方式在文件中 写入时的 差别
 */
public class Ex14 
{
	static String file = "C:/Users/张文迪/Desktop/新建文件夹1/1.txt";
	public static void main(String[] args) throws IOException 
	{
		List<String> list = Ex7.read(file);
		PrintWriter out = new PrintWriter(
				new BufferedWriter(new FileWriter(file)));
		int lineCount = 1;
		long t1 = System.currentTimeMillis();
		for(String s : list) 
		{
			for(int i = 0; i < 30000; i++)
				out.println(lineCount + ": " + s);
			lineCount++;
		}
		long t2 = System.currentTimeMillis();
		System.out.println("buffered: " + (t2 - t1));
		out.close();
		out = new PrintWriter(new FileWriter(file));
		lineCount = 1;
		t1 = System.currentTimeMillis();
		for(String s : list) 
		{
			for(int i = 0; i < 30000; i++)
				out.println(lineCount + ": " + s);
			lineCount++;
		}
		t2 = System.currentTimeMillis();
		System.out.println("unbuffered: " + (t2 - t1));
		out.close();
	}
}
