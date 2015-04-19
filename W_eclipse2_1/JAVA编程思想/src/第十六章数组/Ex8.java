/**
 * �ļ�����Ex8.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-26
 */
package ��ʮ��������;

import java.util.Arrays;

/**
 * @author ���ĵ�
 * ������Ex8
 * ��˵����
 */
public class Ex8<T> 
{
	@SuppressWarnings("unchecked")
	T[] a = (T[])new Object[2]; // Compile warning: unchecked cast
	public static void main(String[] args) 
	{
		String[] sa = new String[2];
		// sa[0] = new Integer(0); // error: incompatible types
		Object[] oa = new Object[3];
		oa[0] = new String("hi");
		oa[1] = new A(); // arbitrary object OK
		int x = 2;
		oa[2] = x; // Autoboxing converts int to Integer:�Զ�ת��Ϊ Interger.
		System.out.println("oa[2]: " + oa[2].getClass());
		//oa = sa;
		System.out.println("oa: " + oa.getClass());
		
		System.out.println(Arrays.deepToString(oa));
		System.out.println(Arrays.deepToString(sa));
		
		sa[0] = "s";
		sa[1] = "o";
		oa = sa;
		System.out.println(Arrays.deepToString(oa));
		
		//System.out.println(Arrays.deepToString(a));
		
		// compiles, but Runtime ArrayStoreException:
		//oa[0] = 3;
	}	
}

