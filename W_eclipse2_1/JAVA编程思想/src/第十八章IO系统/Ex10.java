/**
 * 文件名：Ex10.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * @author 张文迪
 * 类名：Ex10
 * 类说明： 转换为String  查找 单词
 */
public class Ex10
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
		
		LinkedList<String> l7 = read("C:/Users/张文迪/Desktop/新建文件夹1/1.java");  
		for(int i = 0;i<l7.size();i++)
		{
			String s = l7.get(l7.size()-i-1);
			if(s.contains(args[0]))                  //精髓 ！！
				System.out.println(s);
		}
		System.out.println();
	}
}