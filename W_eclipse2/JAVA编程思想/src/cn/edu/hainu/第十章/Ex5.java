/**
 * �ļ�����Ex5.java
 * ��Ŀ-����JAVA���˼�� - cn.edu.hainu.��ʮ��
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-25
 */
package cn.edu.hainu.��ʮ��;


/**
 * @author ���ĵ�
 * ������Ex5
 * ��˵���� �����ⲿ����������� �ڲ���
 */
public class Ex5
{
	public static void main(String args[])
	{
		Outer outer = new Outer();
		//Inner inner = outer.ha111111();
		Outer.Inner inner = outer.new Inner();
		inner.ha1112();
		inner.toString();
		inner.toString();
	}
}
