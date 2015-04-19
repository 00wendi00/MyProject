/**
 * �ļ�����TestJoin.java
 * ��Ŀ-�������߳� - thrMethodPack
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-23
 */
package thrMethodPack;

/**
 * @author ���ĵ�
 * ������TestJoin
 * ��˵����
 */

public class TestJoin
{
	public static void main(String[] args)
	{
		MyThread0 t1 = new MyThread0("abcde");
		t1.start();
		try
		{
			t1.join();
		}
		catch (InterruptedException e)
		{
		}

		for (int i = 1; i <= 10; i++)
		{
			System.out.println("i am main thread");
		}
	}
}

class MyThread0 extends Thread
{
	MyThread0(String s)
	{
		super(s);
	}

	public void run()
	{
		for (int i = 1; i <= 10; i++)
		{
			System.out.println("i am " + getName());
			try
			{
				sleep(1000);
			}
			catch (InterruptedException e)
			{
				return;
			}
		}
	}
}
