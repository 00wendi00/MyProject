/**
 * �ļ�����Echo.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-2
 */
package ��ʮ����IOϵͳ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ���ĵ�
 * ������Echo
 * ��˵����
 */
public class Echo
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while( (s = stdin.readLine()) != null && s.length() != 0)
			System.out.println(s+"!");
		stdin.close();
	}
}
