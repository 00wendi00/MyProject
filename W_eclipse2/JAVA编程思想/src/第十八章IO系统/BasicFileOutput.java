/**
 * �ļ�����BasicFileOutput.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @author ���ĵ�
 * ������BasicFileOutput
 * ��˵���������ļ��� ���~
 */
public class BasicFileOutput
{
	static String file  = "C:/Users/���ĵ�/Desktop/�½��ļ���1/1.java";
	public static void main(String args[]) throws IOException
	{
		// ���ַ��������ж�ȡ�ı�����������ַ����Ӷ�ʵ���ַ���������еĸ�Ч��ȡ��
		BufferedReader in = new BufferedReader(
				new StringReader(BufferedInputFile.read("C:/Users/���ĵ�/Desktop/�½��ļ���1/1.java")));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
										// ��bufferedWriter ��װ�������Ի������~~
		PrintWriter out = new PrintWriter(file);
		int lineCount = 1;
		String s;
		while((s=in.readLine())!= null)
			out.println(lineCount++ +": "+s );
		out.close();
		System.out.println(BufferedInputFile.read(file));
	}                             
}
