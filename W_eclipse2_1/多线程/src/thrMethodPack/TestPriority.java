/**
 * �ļ�����TestPriority.java
 * ��Ŀ-�������߳� - thrMethodPack
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-23
 */
package thrMethodPack;

/**
 * @author ���ĵ�
 * ������TestPriority
 * ��˵����
 */


public class TestPriority
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread t1 = new Thread(new T1());
		Thread t2 = new Thread(new T2());
		//t1.setPriority(Thread.NORM_PRIORITY + 3);
		t1.start();
		t2.start();
		t1.join();
	}
}

class T1 implements Runnable
{
	public void run()
	{
		for (int i = 0; i < 1000; i++)
		{
			System.out.println("T1: " + i);
		}
	}
}

class T2 implements Runnable
{
	public void run()
	{
		for (int i = 0; i < 1000; i++)
		{
			System.out.println("------T2: " + i);
		}
	}
}