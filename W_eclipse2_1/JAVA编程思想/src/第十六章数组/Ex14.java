/**
 * �ļ�����Ex14.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-26
 */
package ��ʮ��������;

import java.util.Arrays;

import net.mindview.util.CountingGenerator;

/**
 * @author ���ĵ�
 * ������Ex14
 * ��˵����
 */
public class Ex14
{
	public static void main(String args[])
	{
		int[] i = new int[5];
		char[] c = new char[5];
		long[] l = new long[5];
		double[] d = new double[5];
		String[] s = new String[5];
		CountingGenerator.Integer ig = new CountingGenerator.Integer();
		CountingGenerator.Character cg = new CountingGenerator.Character();
		CountingGenerator.Long lg = new CountingGenerator.Long();
		CountingGenerator.Double  dg = new CountingGenerator.Double();
		CountingGenerator.String sg = new CountingGenerator.String();
		for(int k =0;k<5;k++)
		{
			i[k] = ig.next();
			c[k] = cg.next();
			l[k] = lg.next();
			d[k] = dg.next();
			s[k] = sg.next();
		}
		System.out.println(Arrays.toString(i));
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(l));
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.toString(s));
	}
}
