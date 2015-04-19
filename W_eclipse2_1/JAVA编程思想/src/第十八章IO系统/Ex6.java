/**
 * �ļ�����Ex6.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author ���ĵ�
 * ������Ex6
 * ��˵����
 */
import java.io.*;
import java.text.*;
import java.util.*;
import net.mindview.util.*;

public class Ex6 
{
	public static void main(String[] args) 
	{
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
		if(args.length != 2) 
		{
			System.err.println("Usage: java E06_ProcessFiles3 path date");
			return;
		}
		long tmp = 0;
		try {
			df.setLenient(false);//ָ������/ʱ������Ƿ��ϸ񡣽��в��ϸ����ʱ�������������ʹ������ʽ�ķ�����������˶���ĸ�ʽ����ȷƥ������롣
								//�����ϸ����ʱ���������ƥ��˶���ĸ�ʽ
							   //Ϊ true ʱ�����������ǲ��ϸ��
			tmp = df.parse(args[1]).getTime();//�Ӹ����ַ����Ŀ�ʼ�����ı���������һ�����ڡ��÷�����ʹ�ø����ַ����������ı���
		} 
		catch(ParseException pe) 
		{
			pe.printStackTrace();  //���� throwable ����׷���������׼������
			return;
		}
		final long modTime = tmp;
		new ProcessFiles(new ProcessFiles.Strategy() 
		{
			public void process(File file) 
			{
				if(modTime < file.lastModified())
					System.out.println(file);
			}
		}, "java").start(new String[] {args[0]});
	}
}
