/**
 * �ļ�����TwoLeiClass.java
 * ��Ŀ-����JAVA���˼�� - �����³�ʼ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-5
 */
package �����³�ʼ��������;
/**
 * @author ���ĵ�
 * ������TwoLeiClass
 * ��˵������ϰ8 �� this �ؼ��֡�
 */
public class TwoLeiClass
{
    public static void main(String args[])
    {
    	new Pen();
    	
    	new Person().ear(new Apple());
    }
}

class Pen
{
	Pen()
	{
		pen1(this)		
		pen1(null);
	}
	private void pen1(Pen pen)
	{
		System.out.println("������");
	}	
}


class Person
{
	public void ear(Apple apple)
	{
		Apple peeled = apple.getPeeled();
		System.out.println("Yummy");
	}
}
class Peeler
{
	static Apple peel(Apple apple)
	{
		return apple;
	}
}
class Apple
{
	Apple getPeeled()
	{
		return Peeler.peel(this);
	}
}