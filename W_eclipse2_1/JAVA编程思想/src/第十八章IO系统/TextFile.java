/**
 * 文件名：TextFile.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author 张文迪
 * 类名：TextFile
 * 类说明：
 */
public class TextFile extends ArrayList<String>
{
	public static String read(String filename)
	{
		StringBuilder sb = new StringBuilder();
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()));
			try
			{
				String s;
				while((s = in.readLine())!=null)
				{
					sb.append(s);
					sb.append("\n");
				}
			}
			finally 
			{
				in.close();
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	public static void write(String filename,String text)
	{
		try
		{
			PrintWriter out = new PrintWriter(filename);
			try
			{
				out.print(text);
			}
			finally
			{
				out.close();
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
	public TextFile(String filename,String splitter)
	{
		super(Arrays.asList(read(filename).split(splitter)));
		if(get(0).equals("")) remove(0);
	}
	public TextFile(String filename)
	{
		this(filename,"\n");
	}
	public void write(String filename)
	{
		try
		{
			PrintWriter out = new PrintWriter(filename);
			try
			{
				for(String item:this)
					out.print(item);
			}
			finally
			{
				out.close();
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
	public static void main(String args[])
	{
		String file = read("C:/Users/张文迪/Desktop/新建文件夹1/2.txt");
		write("C:/Users/张文迪/Desktop/新建文件夹1/2.txt", file);
		TextFile text = new TextFile("C:/Users/张文迪/Desktop/新建文件夹1/2.txt");
		text.write("C:/Users/张文迪/Desktop/新建文件夹1/3.txt");
		TreeSet<String> words = new TreeSet<String>(
				new TextFile("C:/Users/张文迪/Desktop/新建文件夹1/4.txt","\\W+"));
		System.out.println(words.headSet("a"));
		System.out.println(words);
	}
}

