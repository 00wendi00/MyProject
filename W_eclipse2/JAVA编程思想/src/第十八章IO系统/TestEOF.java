/**
 * �ļ�����TestEOF.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ���ĵ�
 * ������TestEOF
 * ��˵����
 */
public class TestEOF
{
	public static void mian(String args[]) throws IOException
	{
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(new FileInputStream("C:/Users/���ĵ�/Desktop/�½��ļ���1/1.java")));
		while(in.available() != 0)   //���Բ��������شӴ��������ж�ȡ�����������Ĺ����ֽ���
			System.out.println((char)in.readByte());
	}
}
