/**
 * �ļ�����Ex1.java
 * ��Ŀ-����JAVA���˼�� - ����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-4
 */
package �ڶ�ʮһ�²���;

/**
 * @author ���ĵ�
 * ������Ex1
 * ��˵����
 */
public class Ex1
{	
	public static void main(String args[])
	{
		for(int i =0;i<3;i++)
		{
			Thread t = new Thread(new MyThread());
			t.start();
		}
	}
}
class MyThread implements Runnable
{
	int i = 5;
	private static int count = 0;
	private final int id = count++ ;
	MyThread()
	{
		System.out.println("#"+id+"#"+"������!!!");
	}
	public String status()
	{
		return "#"+id+"#: "+(i>0? i:"������ ");
	}
	public void run()
	{
		while(i-->0){					
			System.out.println(status());
			Thread.yield();		
		}
		System.out.println("�����ˣ�����");
	}
}
