/**
 * �ļ�����Ex29.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-9
 */
package ��ʮһ��.���ж���;

import java.util.PriorityQueue;

/**
 * @author ���ĵ�
 * ������Ex29
 * ��˵����Exception ~~~~
 */
class Simple extends Object {}

public class Ex29 
{
	public static void main(String[] args)
	{		
		PriorityQueue<Simple> s = new PriorityQueue<Simple>();
		// OK to add one Simple:
		s.offer(new Simple());
		// but no more allowed; get runtime exception: 
		// Simple cannot be cast to Comparable:
		s.offer(new Simple());
	}
}