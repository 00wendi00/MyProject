/**
 * �ļ�����Ex15.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-8
 */
package ��ʮһ��.���ж���;

import java.util.Stack;

/**
 * @author ���ĵ�
 * ������Ex15
 * ��˵���� Ӧ���� Character~~~   ++++  split ���÷�  .   
 */
public class Ex15
{
	public static void main(String args[])
	{
		Stack<String> st = new Stack<String>();
		for(String s : "U n c".split(" "))
			st.push(s);
		while(!st.empty())
			System.out.println(st.pop()+" ");
	}
}
