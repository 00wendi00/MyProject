/**
 * �ļ�����Ex7.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author ���ĵ�
 * ������Ex7
 * ��˵������ϰ 7 ��8 ~~~
 * C:/Users/���ĵ�/Desktop/�½��ļ���1/1.java   ����·��
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
		
		LinkedList<String> l7 = read("C:/Users/���ĵ�/Desktop/�½��ļ���1/1.java");  //7
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
