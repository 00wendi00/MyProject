/**
 * �ļ�����Ex9.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����ַ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-14
 */
package ��ʮ�����ַ���;

/**
 * @author ���ĵ�
 * ������Ex9
 * ��˵����replaceAll("[aeiouAEIOU]", "_")
 */
public class Ex9
{
	public static String knights =
		"Then, when you have found the shrubbery, you must " +
		"cut down the mightiest tree in the forest... " +
		"with... a herring!";
	public static void main(String[] args) 
	{
		System.out.println(knights.replaceAll("[aeiouAEIOU]", "_"));
	}
}
