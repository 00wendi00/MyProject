/**
 * �ļ�����BufferedInputFile.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ���ĵ�
 * ������BufferedInputFile
 * ��˵����
 */
public class BufferedInputFile
{
	public static String read(String filename) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		//һ���ɱ���ַ����С������ṩһ���� StringBuffer ���ݵ� API��������֤ͬ����
		//���౻������� StringBuffer ��һ�������滻�������ַ����������������߳�ʹ�õ�ʱ������������ձ飩��
		//������ܣ��������Ȳ��ø��࣬��Ϊ�ڴ����ʵ���У����� StringBuffer Ҫ�졣 
		while((s = in.readLine())!=null)
			sb.append(s+"\n");
		in.close();
		return sb.toString();
	}
	public static void main(String args[]) throws IOException
	{
		System.out.println(read(args[0]));
	}
}
