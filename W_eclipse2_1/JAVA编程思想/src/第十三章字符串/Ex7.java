/**
 * �ļ�����Ex7.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����ַ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-14
 */
package ��ʮ�����ַ���;

/**
 * @author ���ĵ�
 * ������Ex7
 * ��˵���� ��д��ĸ��ͷ~�Ծ�Ž�β~   String sen = "^[A-Z].*[\\.]$"; 
 */
public class Ex7
{
	static String s = "Wo nimabi haha.";
	static String k = "~~~~~~~~~~~";
	public static void main(String args[])
	{
		String sen = "^[A-Z].*[\\.]$";  //~~~~~~
		System.out.println(s.matches(sen));
		System.out.println(s.matches(k));
	}
}
