/**
 * �ļ�����MemoryInput.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author ���ĵ�
 * ������MemoryInput
 * ��˵����  read() ��ȡ�����ַ�����ȡ���ַ�������ѵ�������ĩβ���򷵻� -1 
 */
public class MemoryInput
{
	public static void main(String args[]) throws IOException
	{
		StringReader in  = new StringReader(BufferedInputFile.read("C:/Users/���ĵ�/Desktop/�½��ļ���1/1.java"));
		int c;
		while((c = in.read()) != -1)    
			System.out.print((char)c);
	}
}
