/**
 * �ļ�����Ex13.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;


import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @author ���ĵ�
 * ������Ex13
 * ��˵����
 */

public class Ex13
{
	static String file = "C:/Users/���ĵ�/Desktop/�½��ļ���1/1.java";
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

