/**
 * �ļ�����RandomChars.java
 * ��Ŀ-����JAVA���˼�� - cn.edu.hainu.�ھ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-24
 */
package cn.edu.hainu.�ھ���;

import java.util.Random;

/**
 * @author ���ĵ�
 * ������RandomChars
 * ��˵���� ��ϰ 16~~~
 */
public class RandomChars 
{
	private static Random rand = new Random();
	public char next() 
	{
		return (char)rand.nextInt(128);		
	}
	public static void main(String[] args) 
	{			
		RandomChars rc = new RandomChars();
		for(int i = 0; i < 10; i++)
		System.out.print(rc.next() + " ");
	}
}
