/**
 * 文件名：ProducerConsumer.java
 * 项目-包：多线程 - syncPack1
 * 作者：张文迪
 * 创建日期：2014-5-23
 */
package syncPack1;

/**
 * @author 张文迪
 * 类名：ProducerConsumer
 * 类说明：
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
 * 类名：WoTou
 * 类说明：馒头类
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
 * 类名：SyncStack
 * 类说明：框类
 */
class SyncStack
{
	int index = 0;
	WoTou[] arrWT = new WoTou[6];  //框，只能放6个馒头

	/**
	 * 方法说明：往框里面放
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
	 * 方法说明：从框里面取
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
 * 类名：Producer
 * 类说明：生产者生产馒头
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
			System.out.println("生产了：" + wt);
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
 * 类名：Consumer
 * 类说明：消费者
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
			System.out.println("消费了: " + wt);
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