/**
 * �ļ�����Finding.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����ַ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-16
 */
package ��ʮ�����ַ���;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ���ĵ�
 * ������Finding
 * ��˵����
 */
public class Finding
{
	public static void main(String args[])
	{
		Matcher m = Pattern.compile("\\w+").matcher("Evening is full of the linnet's wings");
		while(m.find())
			System.out.print(m.group()+" ");
		System.out.println();
		int i =0;
		while(m.find(i))
		{
			//System.out.print(i+" ");
			System.out.print(m.group()+" ");
			i++;
		}
	}
}
