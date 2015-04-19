/**
 * �ļ�����ProducerConsumer.java
 * ��Ŀ-�������߳� - syncPack1
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-23
 */
package syncPack1;

/**
 * @author ���ĵ�
 * ������ProducerConsumer
 * ��˵����
 */


public class ProducerConsumer
{
	public static void main(String[] args)
	{
		SyncStack ss = new SyncStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		new Thread(p).start();
		//new Thread(p).start();
		//new Thread(p).start();
		new Thread(c).start();
	}
}
/**
 * @author eagler_hu
 * ������WoTou
 * ��˵������ͷ��
 */
class WoTou
{
	int id;

	WoTou(int id)
	{
		this.id = id;
	}

	public String toString()
	{
		return "WoTou : " + id;
	}
}

/**
 * @author eagler_hu
 * ������SyncStack
 * ��˵��������
 */
class SyncStack
{
	int index = 0;
	WoTou[] arrWT = new WoTou[6];  //��ֻ�ܷ�6����ͷ

	/**
	 * ����˵�������������
	 * @param wt
	 */
	public synchronized void push(WoTou wt)
	{
		while (index == arrWT.length)
		{
			try
			{
				this.wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		this.notifyAll();
		arrWT[index] = wt;
		index++;
	}

	/**
	 * ����˵�����ӿ�����ȡ
	 * @return
	 */
	public synchronized WoTou pop()
	{
		while (index == 0)
		{
			try
			{
				this.wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		this.notifyAll();
		index--;
		return arrWT[index];
	}
}

/**
 * @author eagler_hu
 * ������Producer
 * ��˵����������������ͷ
 */
class Producer implements Runnable
{
	SyncStack ss = null; 
	int num = 0;

	Producer(SyncStack ss)
	{
		this.ss = ss;
	}

	public void run()
	{
		for (int i = 0; i < 20; i++)
		{
			WoTou wt = new WoTou(num++);
			ss.push(wt);
			System.out.println("�����ˣ�" + wt);
			try
			{
				Thread.sleep((int) (Math.random() * 200));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}

/**
 * @author eagler_hu
 * ������Consumer
 * ��˵����������
 */
class Consumer implements Runnable
{
	SyncStack ss = null;

	Consumer(SyncStack ss)
	{
		this.ss = ss;
	}

	public void run()
	{
		for (int i = 0; i < 20; i++)
		{
			WoTou wt = ss.pop();
			System.out.println("������: " + wt);
			try
			{
				Thread.sleep((int) (Math.random() * 1000));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}