/**
 * �ļ�����TestRegularExpression.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����ַ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-16
 */
package ��ʮ�����ַ���;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ���ĵ�
 * ������TestRegularExpression
 * ��˵����p300����~~����̨����~~~
 */
public class TestRegularExpression
{
	public static void main(String[] args)
	{
		if(args.length<2)
		{
			System.out.println("Usage:\njava TestRegularExpression" + "characterSequence regularExpression+");
			System.exit(0);
		}
		System.out.println("Input:\""+args[0]+"\"");
		for(String arg:args)
		{
			System.out.println("222222Regular expression:\""+arg+"\"");
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			while(m.find())
			{
				System.out.println("111111"+"Match\""+m.group()+"\"at positions"+m.start()+"-"+(m.end()-1));
			}
		}
	}
}
