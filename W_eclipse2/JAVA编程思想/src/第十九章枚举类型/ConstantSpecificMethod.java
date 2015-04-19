/**
 * �ļ�����ConstantSpecificMethod.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����ö������
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-3
 */
package ��ʮ����ö������;

import java.util.*;
import java.text.*;
/**
 * @author ���ĵ�
 * ������ConstantSpecificMethod
 * ��˵����
 */
public enum ConstantSpecificMethod
{
	DATE_TIME{
		String getInfo(){
			return 
				DateFormat.getDateInstance().format(new Date());
		}
	},
	CLASSPATH{
		String getInfo(){
			return System.getenv("CLASSPATH");   //��ȡָ���Ļ�������ֵ������������һ��ȡ����ϵͳ���ⲿָ����ֵ��
		}
	},
	VERSION{
		String getInfo(){
			return System.getProperty("java.version");  //��ȡָ����ָʾ��ϵͳ����
		}
	};
	abstract String getInfo();
	public static void main(String args[])
	{
		for(ConstantSpecificMethod csm: values())
			System.out.println(csm.getInfo());
	}
}
