/**
 * �ļ�����GenericMethods.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���·���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-21
 */
package ��ʮ���·���;

/**
 * @author ���ĵ�
 * ������GenericMethods
 * ��˵����
 */
public class GenericMethods9
{
	public <A,B,C> void f(A a,B b,C c)
	{
		System.out.println(a.getClass().getName()+" "+b.getClass().getName()+" "+c.getClass().getName());
	}
	public static void main(String args[])
	{
		GenericMethods9 ge = new GenericMethods9();
		ge.f(1, "!!!", 'q');
	}
}
