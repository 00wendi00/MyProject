/**
 * �ļ�����Ex6.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-26
 */
package ��ʮ��������;

import java.util.Arrays;

/**
 * @author ���ĵ�
 * ������Ex6
 * ��˵������ϰ 6~7
 */
public class Ex67
{
	static A[][][] haha6(int p,int q,int k)
	{
		A[][][] a = new A[p][q][k];
		for(int i = 0;i<p;i++)
		   for(int u =0;u<q;u++)
			   for(int y=0;y<k;y++)
				   a[i][u][y] = new A();
		return a;
	}
	public static void main(String args[])
	{
		System.out.println(Arrays.deepToString(haha6(2,2,2)));
	}
}
