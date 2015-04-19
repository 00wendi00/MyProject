/**
 * 文件名：FilesCopy.java
 * 项目-包：期末恶补 - io流copy
 * 作者：张文迪
 * 创建日期：2014-6-26
 */
package io流copy;

/**
 * @author 张文迪
 * 类名：FilesCopy
 * 类说明：
 */

//FilesCopy.java源代码如下：
import java.io.*;

public class FilesCopy
{
	public static void main(String[] args) throws IOException
	{
		// 首先定义两个文件，它们都是File的实例
		// 源文件在当前目录的父目录中
		File inputFile = new File(".\\partnovel.txt");
		File outputFile = new File(".\\target1.txt");
		// 然后在两个文件上建立以字符为单位的输入和输出流
		// 中文与英文都是一个字符
		FileReader in = new FileReader(inputFile);
		FileWriter out = new FileWriter(outputFile);
		// 从输入流中读取数据，暂存于c，然后把它写入输出流
		// 由于输入、输出流建立在文件上，就相当于对文件读写
		char c;
		while ((c = (char)in.read()) != -1)
		{ // 其中的-1指示文件末
			out.write(c);
			System.out.print(c + ">>"); // 输出字符编码到屏幕
		}
		// 关闭输入、输出流
		in.close();
		out.close();
	}
}
