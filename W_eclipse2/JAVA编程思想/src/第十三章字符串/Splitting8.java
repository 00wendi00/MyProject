/**
 * �ļ�����Splitting8.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����ַ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-14
 */
package ��ʮ�����ַ���;

import java.util.Arrays;

/**
 * @author ���ĵ�
 * ������Splitting8
 * ��˵����Arrays.toString(knights.split(regex))
 */
public class Splitting8 
{
	public static String knights =
		"Then, when you have found the shrubbery, you must " +
		"cut down the mightiest tree in the forest... " +
		"with... a herring!";
	public static void split(String regex) 
	{
		System.out.println(Arrays.toString(knights.split(regex)));
	}
	public static void main(String[] args) 
	{
		split("the|you");
	}
}