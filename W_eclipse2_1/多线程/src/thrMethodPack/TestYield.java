/**
 * �ļ�����TestYield.java
 * ��Ŀ-�������߳� - thrMethodPack
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-23
 */
package thrMethodPack;

/**
 * @author ���ĵ�
 * ������TestYield
 * ��˵����
 */

public class TestYield
{
	public static void main(String[] args)
	{
		MyThread4 th1 = new MyThread4("t1");
		MyThread4 th2 = new MyThread4("t2");
		th1.start();
		th2.start();
	}
}

class MyThread4 extends Thread
{
	MyThread4(String s)
	{
		super(s);
	}

	public void run()
	{
		for (int i = 1; i <= 100; i++)
		{
			System.out.println(getName() + ": " + i);
			if (i % 10 == 0)
			{
				yield();  //��ǰ�߳��ó�cpu���������߳����С�
			}
		}
	}
}
