/**
 * �ļ�����Ex20.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���·���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-21
 */
package ��ʮ���·���;

/**
 * @author ���ĵ�
 * ������Ex20
 * ��˵������ϰ20~~~�������Ͳ����ı߽�����  extends 
 */
public class Ex20 
{
	public static void main(String args[])
	{
		MyClass201 myClass201 = new MyClass201();
		MyClass202 myClass202 = new MyClass202();
		//myClass202.haha111(myClass201);
		MyClass202.haha111(myClass201); // Ӧ�þ�̬����~~
	}
}

interface MyHeihei20
{
	void heihei1();
	void heihei2();
}
class MyClass201 implements MyHeihei20
{
	public void heihei1()
	{
		System.out.println("111");
	}
	public void heihei2()
	{
		System.out.println("222");
	}	
	public void haha20()
	{
		System.out.println("haha20");
	}
}
class MyClass202
{
	public static <T extends MyHeihei20> void haha111(T t)
	{
		t.heihei1();
		t.heihei2();
		System.out.println("haha111");
	}
}
