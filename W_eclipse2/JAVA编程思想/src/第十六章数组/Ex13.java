/**
 * �ļ�����Ex13.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-26
 */
package ��ʮ��������;

/**
 * @author ���ĵ�
 * ������Ex13
 * ��˵����
 */
import net.mindview.util.*;


public class Ex13 
{
	public static String fillString(int len) 
	{
		CountingGenerator.Character cg = new CountingGenerator.Character();
		char[] ca = new char[len];
		for(int i = 0; i < len; i++)
			ca[i] = cg.next();
		return new String(ca);		
	}
	public static void main(String[] args)
	{
		System.out.println(fillString(7));
		System.out.println(fillString(10));
	}
}
