/**
 * 文件名：BufferedInputFile.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 张文迪
 * 类名：BufferedInputFile
 * 类说明：
 */
public class BufferedInputFile
{
	public static String read(String filename) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		//一个可变的字符序列。此类提供一个与 StringBuffer 兼容的 API，但不保证同步。
		//该类被设计用作 StringBuffer 的一个简易替换，用在字符串缓冲区被单个线程使用的时候（这种情况很普遍）。
		//如果可能，建议优先采用该类，因为在大多数实现中，它比 StringBuffer 要快。 
		while((s = in.readLine())!=null)
			sb.append(s+"\n");
		in.close();
		return sb.toString();
	}
	public static void main(String args[]) throws IOException
	{
		System.out.println(read(args[0]));
	}
}
