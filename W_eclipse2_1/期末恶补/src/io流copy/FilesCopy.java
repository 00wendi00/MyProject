/**
 * �ļ�����FilesCopy.java
 * ��Ŀ-������ĩ�� - io��copy
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-26
 */
package io��copy;

/**
 * @author ���ĵ�
 * ������FilesCopy
 * ��˵����
 */

//FilesCopy.javaԴ�������£�
import java.io.*;

public class FilesCopy
{
	public static void main(String[] args) throws IOException
	{
		// ���ȶ��������ļ������Ƕ���File��ʵ��
		// Դ�ļ��ڵ�ǰĿ¼�ĸ�Ŀ¼��
		File inputFile = new File(".\\partnovel.txt");
		File outputFile = new File(".\\target1.txt");
		// Ȼ���������ļ��Ͻ������ַ�Ϊ��λ������������
		// ������Ӣ�Ķ���һ���ַ�
		FileReader in = new FileReader(inputFile);
		FileWriter out = new FileWriter(outputFile);
		// ���������ж�ȡ���ݣ��ݴ���c��Ȼ�����д�������
		// �������롢������������ļ��ϣ����൱�ڶ��ļ���д
		char c;
		while ((c = (char)in.read()) != -1)
		{ // ���е�-1ָʾ�ļ�ĩ
			out.write(c);
			System.out.print(c + ">>"); // ����ַ����뵽��Ļ
		}
		// �ر����롢�����
		in.close();
		out.close();
	}
}
