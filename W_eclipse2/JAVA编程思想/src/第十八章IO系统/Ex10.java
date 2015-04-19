/**
 * �ļ�����Ex10.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * @author ���ĵ�
 * ������Ex10
 * ��˵���� ת��ΪString  ���� ����
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
		
		LinkedList<String> l7 = read("C:/Users/���ĵ�/Desktop/�½��ļ���1/1.java");  
		for(int i = 0;i<l7.size();i++)
		{
			String s = l7.get(l7.size()-i-1);
			if(s.contains(args[0]))                  //���� ����
				System.out.println(s);
		}
		System.out.println();
	}
}