/**
 * �ļ�����GenericMethods10.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���·���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-21
 */
package ��ʮ���·���;

/**
 * @author ���ĵ�
 * ������GenericMethods10
 * ��˵����
 */
public class GenericMethods10
{
	public <MyClass10,B,C> void f(MyClass10 myClass10,B b,C c)
	{
		System.out.println(myClass10.getClass().getName()+" "+b.getClass().getName()+" "+c.getClass().getName());
	}
	public static void main(String args[])
	{
		GenericMethods9 ge = new GenericMethods9();
		ge.f(new MyClass10(), "!!!", 'q');
	}
}
class MyClass10
{
	MyClass10()
	{
		System.out.println("obc   nonononono no");
	}
}
