/**
 * �ļ�����Reddirecting.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-2
 */
package ��ʮ����IOϵͳ;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * @author ���ĵ�
 * ������Reddirecting
 * ��˵���� �������ǲ��ܰ�BufferedStream������ʵ�ʿ��õ�������ʵ���Ǳ����װһ��������ʵ��IO�豸�������ܲ���������˵System.in��System.out��������������ַ�������һ�ְ�װ��������
		����˵InputStream���������ã�
		InputStream in = new BufferedInputStream(new BufferedInputStream(System.in));
		���ַ����أ�
    	��ʵ�ַ���û��ʵ�ʵ���ʽ��ֻ����ͨ����װһЩ�ر�����������ܽ����ַ�����������˵��װ�ֽ���InputStream��
		Reader reader = new InputStreamReader(System.in);
		�ٱ���˵��װ�ַ����飺
		char[] in = new char[1024];
		Reader reader = new CharArrayReader(in);
 * 
 * 
 *   ��  �� �����κ��������������ݵ�    ����Դ����    ����   �������������ݵ�  ���ն˶���~~
 */
public class Reddirecting
{
	public static void main(String args[]) throws IOException
	{
		PrintStream console = System.out;
		BufferedInputStream in  = new BufferedInputStream(
				new FileInputStream("C:/Users/���ĵ�/Desktop/�½��ļ���1/2.txt"));
		PrintStream out = new PrintStream(
				new BufferedOutputStream(new FileOutputStream("C:/Users/���ĵ�/Desktop/�½��ļ���1/3.txt")));
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s ;
		while((s = br.readLine()) != null)
			System.out.println(s);
		out.close();
		System.setOut(console);
	}
}
