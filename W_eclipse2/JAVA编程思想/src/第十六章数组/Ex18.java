/**
 * �ļ�����eX18.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-27
 */
package ��ʮ��������;

import java.util.Arrays;

/**
 * @author ���ĵ�
 * ������eX18
 * ��˵����
 */
public class Ex18
{
	public static void main(String args[])
	{
		A[] a = new A[4];
		for(int i = 0;i<4;i++)
			a[i] = new A();
		System.out.println(Arrays.toString(a));
		
		A[] b = new A[5];
		System.arraycopy(a, 0, b, 1, a.length);
		System.out.println(Arrays.toString(b));
	}
}
