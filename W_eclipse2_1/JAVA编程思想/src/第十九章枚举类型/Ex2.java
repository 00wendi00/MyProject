/**
 * �ļ�����Ex2.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����ö������
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-3
 */
package ��ʮ����ö������;

import java.util.Random;

/**
 * @author ���ĵ�
 * ������Ex2
 * ��˵����static next()����ȡ��Generater�ӿ�
 */
enum CartoonCharacter
{
	SLAPPY,HAHA,HAODELA,NIMKJ,ADSSDA;
	static Random random = new Random(47);
	static CartoonCharacter next()
	{
		return values()[random.nextInt(values().length)];
	}
}
public class Ex2
{
	public static void main(String args[])
	{
		for(int i=0;i<8;i++)
		{			
			System.out.println(CartoonCharacter.next());
		}
	}
}
