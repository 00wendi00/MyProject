/**
 * �ļ�����Ex10.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����ַ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-16
 */
package ��ʮ�����ַ���;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ���ĵ�
 * ������Ex10
 * ��˵����
 */
public class Ex10
{
	private static String s = "Java now has regular expressions";
	private static String k[] = {"^java","\breg.*","s?","s*","s+","s{4}","s{0,3}","Java"};
	public static void main(String args[])
	{
		for(String k1:k)
		{
			Pattern p = Pattern.compile(k1);
			Matcher m = p.matcher(s);
			System.out.println(m.matches());
		}
	}
}
