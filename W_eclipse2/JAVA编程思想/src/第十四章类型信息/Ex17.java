/**
 * �ļ�����Ex17.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����������Ϣ
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-19
 */
package ��ʮ����������Ϣ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ���ĵ�
 * ������Ex17
 * ��˵�����ַ����滻~~~
 */
public class Ex17
{
	public static void main(String args[])
	{
		String s = "native,final";
		System.out.println(s);
		Pattern p = Pattern.compile("(\\w+\\.)|\\s*final|\\s*native");
		Matcher m = p.matcher(s);		
		while(m.find())
		{
			System.out.println(m.start());
			System.out.println(m.end());
			System.out.println(m.group());
			System.out.println(m.replaceAll(""));
			//System.out.println(m.group());
		}
	}
}
