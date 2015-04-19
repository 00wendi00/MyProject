/**
 * 文件名：Ex13.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;


import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @author 张文迪
 * 类名：Ex13
 * 类说明：
 */

public class Ex13
{
	static String file = "C:/Users/张文迪/Desktop/新建文件夹1/1.java";
	public static void main(String[] args)throws IOException 
	{
		// LineNumberReader is inherited from
		// BufferedReader so we don't need to
		// explicitly buffer it:
		LineNumberReader in =new LineNumberReader(
				new StringReader(BufferedInputFile.read(file)));
		PrintWriter out = new PrintWriter(file);
		String s = "";
		while((s = in.readLine()) != null )
		{
			out.println(in.getLineNumber() + ": " + s);
		}
		out.close();
		// Show the stored file:
		System.out.println(BufferedInputFile.read(file));
	
	}
}

