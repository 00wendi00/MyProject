/**
 * �ļ�����Ex12.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * @author ���ĵ�
 * ������Ex12
 * ��˵�����������ļ����~~~ ��3 �� args[0]
 */
public class Ex12
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader in = new BufferedReader(
				new StringReader(BufferedInputFile.read(args[0]))); // ��
		PrintWriter out = new PrintWriter(args[0]);  //д
		String w = "!!!!!!!!!!";
		String s ;
		while((s = in.readLine()) != null)
			out.println(w+"w~~~"+": "+s);
		out.close();
		System.out.println(BufferedInputFile.read(args[0]));   // ���
	}
}
