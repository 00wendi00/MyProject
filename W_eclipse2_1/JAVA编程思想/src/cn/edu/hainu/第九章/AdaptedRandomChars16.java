/**
 * �ļ�����AdaptedRandomChars16.java
 * ��Ŀ-����JAVA���˼�� - cn.edu.hainu.�ھ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-24
 */
package cn.edu.hainu.�ھ���;

import java.nio.CharBuffer;
import java.util.Scanner;
/**
 * @author ���ĵ�
 * ������AdaptedRandomChars16
 * ��˵���� ��ϰ 16~~~
 */
public class AdaptedRandomChars16 extends RandomChars implements Readable 
{
	private int count;
	
	public AdaptedRandomChars16(int count) 
	{
		this.count = count;
	}			
	public int read(CharBuffer cb) 
	{
		if(count-- == 0) 
			return -1;
		String result = Character.toString(next()) + " ";
		cb.append(result);
		return result.length();
	}
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(new AdaptedRandomChars16(10));
		while(s.hasNext())
			System.out.print(s.next() + " ");
		System.out.println();
	}
}