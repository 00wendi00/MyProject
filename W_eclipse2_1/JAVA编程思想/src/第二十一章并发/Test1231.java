/**
 * �ļ�����Test1231.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-7
 */
package �ڶ�ʮһ�²���;

import java.text.NumberFormat;
import java.util.Random;

/**
 * @author ���ĵ�
 * ������Test1231
 * ��˵����ģ���� 100000000 ��Ӳ��~~~ �鿴����� �ٷֺ������~~~
 */
public class Test1231
{
	public static void main(String args[])
	{
		Random rand = new Random();
		int i = 0;
		int k = 0;
		for(int m = 0;m<100000000;m++)
		{
			i += rand.nextInt(2);
			k += rand.nextInt(2);
		}
		double d = (double)i/(double)k;
		 NumberFormat nt = NumberFormat.getPercentInstance(); //���ص�ǰĬ�����Ի����İٷֱȸ�ʽ�� 
		 	//NumberFormat  ��������ֵ��ʽ�ĳ������
		 nt.setMinimumFractionDigits(5);
		System.out.println(i);
		System.out.println(k);
		System.out.println(nt.format(d));
	}
}
