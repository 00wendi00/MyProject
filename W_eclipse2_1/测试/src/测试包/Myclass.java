/**
 * �ļ�����Myclass.java
 * ��Ŀ-�������� - ���԰�
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-20
 */
package ���԰�;

/**
 * @author ���ĵ�
 * ������Myclass
 * ��˵������14 �£���ϰ25���ӿ���������Ϣ //final���ε����ܸ�д~~
 */
class Myclass implements A
{
	public void f1()
	{
		System.out.println("������f1");
	}
	private void f2()
	{
		System.out.println("������f2");
	}
	private int i = 2;
	private final int k = 100; 
	private final String s = "~~~~~~~~~";
	public String toString()
	{
		return "k = "+k + ",s = "+s;
	}
}

