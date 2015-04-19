/**
 * �ļ�����TextFile.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author ���ĵ�
 * ������TextFile
 * ��˵����
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
		String file = read("C:/Users/���ĵ�/Desktop/�½��ļ���1/2.txt");
		write("C:/Users/���ĵ�/Desktop/�½��ļ���1/2.txt", file);
		TextFile text = new TextFile("C:/Users/���ĵ�/Desktop/�½��ļ���1/2.txt");
		text.write("C:/Users/���ĵ�/Desktop/�½��ļ���1/3.txt");
		TreeSet<String> words = new TreeSet<String>(
				new TextFile("C:/Users/���ĵ�/Desktop/�½��ļ���1/4.txt","\\W+"));
		System.out.println(words.headSet("a"));
		System.out.println(words);
	}
}

