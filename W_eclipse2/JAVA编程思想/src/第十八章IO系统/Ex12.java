/**
 * 文件名：Ex12.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @author 张文迪
 * 类名：Ex12
 * 类说明：基本的文件输出~~~ 和3 个 args[0]
 */
public class Ex12
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader in = new BufferedReader(
				new StringReader(BufferedInputFile.read(args[0]))); // 读
		PrintWriter out = new PrintWriter(args[0]);  //写
		String w = "!!!!!!!!!!";
		String s ;
		while((s = in.readLine()) != null)
			out.println(w+"w~~~"+": "+s);
		out.close();
		System.out.println(BufferedInputFile.read(args[0]));   // 输出
	}
}
