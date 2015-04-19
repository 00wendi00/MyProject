/**
 * �ļ�����Ex14.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author ���ĵ�
 * ������Ex14
 * ��˵���� ����  �л���/�޻��� ��I/O��ʽ���ļ��� д��ʱ�� ���
 */
public class Ex14 
{
	static String file = "C:/Users/���ĵ�/Desktop/�½��ļ���1/1.txt";
	public static void main(String[] args) throws IOException 
	{
		List<String> list = Ex7.read(file);
		PrintWriter out = new PrintWriter(
				new BufferedWriter(new FileWriter(file)));
		int lineCount = 1;
		long t1 = System.currentTimeMillis();
		for(String s : list) 
		{
			for(int i = 0; i < 30000; i++)
				out.println(lineCount + ": " + s);
			lineCount++;
		}
		long t2 = System.currentTimeMillis();
		System.out.println("buffered: " + (t2 - t1));
		out.close();
		out = new PrintWriter(new FileWriter(file));
		lineCount = 1;
		t1 = System.currentTimeMillis();
		for(String s : list) 
		{
			for(int i = 0; i < 30000; i++)
				out.println(lineCount + ": " + s);
			lineCount++;
		}
		t2 = System.currentTimeMillis();
		System.out.println("unbuffered: " + (t2 - t1));
		out.close();
	}
}
