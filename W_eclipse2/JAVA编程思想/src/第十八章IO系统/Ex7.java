/**
 * 文件名：Ex7.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author 张文迪
 * 类名：Ex7
 * 类说明：练习 7 ，8 ~~~
 * C:/Users/张文迪/Desktop/新建文件夹1/1.java   绝对路径
 */
public class Ex7
{
	public static LinkedList<String> read(String filename) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		
		//StringBuilder sb = new StringBuilder();
		
		LinkedList<String> l = new LinkedList<String>() ;
		while((s = in.readLine())!=null)
		{
			l.add(s);
		}
		return l;
	}
	public static void main(String args[]) throws IOException
	{ 
		LinkedList<String> l8 = read(args[0]) ;                   //8
		for(int i = 0;i<l8.size();i++)
		{
			System.out.println(l8.get(l8.size()-i-1));
		}
		System.out.println();
		
		LinkedList<String> l7 = read("C:/Users/张文迪/Desktop/新建文件夹1/1.java");  //7
		for(int i = 0;i<l7.size();i++)
		{
			System.out.println(l7.get(l7.size()-i-1));
		}
		System.out.println();
		
		LinkedList<String> l9 = read(args[0]) ;                   //9
		for(int i = 0;i<l9.size();i++)
		{
			String string = l9.get(l9.size()-i-1);
			string = string.toUpperCase();
			System.out.println(string);
		}
	}
}
