/**
 * �ļ�����TestSync.java
 * ��Ŀ-�������߳� - syncPack1
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-23
 */
package syncPack1;

/**
 * @author ���ĵ�
 * ������TestSync
 * ��˵����
 */

/*����İ취�������߳�ִ��timer�����ʱ��������ǰ���� ��
  һ��synchronized���ڷ����У���ִ�и÷������̵��е�ǰ��������
 ����һ�֣�synchronized���ڷ�������
 ȱ�㣺Ч�ʻή��
 �ŵ㣺�������ǰ��һ�µ�����
 */
public class TestSync implements Runnable
{
	Timer timer = new Timer();

	public static void main(String[] args)
	{
		TestSync test = new TestSync();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}

	public void run()
	{
		timer.add(Thread.currentThread().getName());
	}
}

class Timer
{
	private static int num = 0;

	public /*synchronized*/ void add(String name)
	{
	  //synchronized (this)  //��ס��ǰ����
	  //{
		num++;
		try
		{
			Thread.sleep(1);  //sleep��ʱ���ͷ���
		}
		catch (InterruptedException e)
		{
		}
		System.out.println(name + ", ���ǵ�" + num + "��ʹ��timer������߳�");
	 //}
	}
}

