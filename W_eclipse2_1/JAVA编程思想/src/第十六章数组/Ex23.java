/**
 * �ļ�����Ex23.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-27
 */
package ��ʮ��������;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * @author ���ĵ�
 * ������Ex23
 * ��˵����������������� �ģ����� �����Լ��ķ�ʽ(˳��һ����)���򣬲���
 *	             ���û�ҵ����� ���ظ�����
 */
public class Ex23
{
	public static void main(String args[])
	{
		Integer[] integers = new Integer[10];
		Random random = new Random();
		for(int i =0;i<10;i++)
			integers[i] = (Integer)random.nextInt(10);
		System.out.println(Arrays.toString(integers));
		int index1 = Arrays.binarySearch(integers, 3);
		System.out.println(index1);
		
		Arrays.sort(integers);
		System.out.println(Arrays.toString(integers));
		int index2 = Arrays.binarySearch(integers, 3);
		System.out.println(index2);  // ������������� �ģ����� �����Լ��ķ�ʽ(˳��һ����)���򣬲���
									//  ���û�ҵ����� ���ظ�����
		
		Arrays.sort(integers,Collections.reverseOrder());
		System.out.println(Arrays.toString(integers));	
		int index3 = Arrays.binarySearch(integers, 3);
		System.out.println(index3);
	}
}
