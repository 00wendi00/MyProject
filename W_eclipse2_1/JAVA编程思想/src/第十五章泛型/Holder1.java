/**
 * �ļ�����Holder1.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���·���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-20
 */
package ��ʮ���·���;

/**
 * @author ���ĵ�
 * ������Holder1
 * ��˵������ϰ1  ���л�������   �Ϳ���  �����������ͣ�
 */
public class Holder1<T>
{
	private T a ;
	public Holder1(T a) {this.a = a;}
	public void set(T a) {this.a = a;}
	public T get() {return a;}
	public static void main(String args[])
	{
		Holder1<A1> h1 = new Holder1<A1>(new A1());
		A1 a1 = h1.get(); 
		a1.a1111();
		
		Holder1<B1> h2 = new Holder1<B1>(new B1());
		B1 b1 = h2.get();
		b1.a1111();
		b1.b1111();
	}
}
class A1
{
	void a1111()
	{
		System.out.println("111");
	}
}
class B1 extends A1
{
	void b1111()
	{
		System.out.println("222");
	}
	
}
