/**
 * �ļ�����TestRegularExpression10.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����ַ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-16
 */
package ��ʮ�����ַ���;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ���ĵ�
 * ������TestRegularExpression10
 * ��˵����
 */

public class TestRegularExpression10 
{
	public static void main(String[] args) 
	{
		if(args.length < 2) 
		{
			System.out.println("Usage:\njava TestRegularExpression " + 
				"characterSequence regularExpression+");
			System.exit(0);  
		}
		System.out.println("Input: \"" + args[0] + "\"");
		for(String arg : args) 
		{
			System.out.println("Regular expression: \"" + arg + "\"");
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			if(!m.find()) 
			  	System.out.println("No match found for " + "\"" + arg + "\"");
			m.reset();
			while(m.find()) 
			{
				System.out.println("Match \"" + m.group() + "\" at position " +
					m.start() + ((m.end() - m.start() < 2) ? "" :  ("-" + (m.end() - 1))));
			}
		}
	}
}
