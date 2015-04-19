/**
 * 文件名：TestDeadLock.java
 * 项目-包：多线程 - syncPack1
 * 作者：张文迪
 * 创建日期：2014-5-23
 */
package syncPack1;

/**
 * @author 张文迪
 * 类名：TestDeadLock
 * 类说明：
 */

/*死锁模拟-哲学家吃饭的问题
  解决方法 ：将锁的粒度加粗，只用一个对象锁
  很难涉及到，加了锁就要小心死锁的问题*/
public class TestDeadLock implements Runnable
{
	public int flag = 1;
	static Object o1 = new Object(), o2 = new Object();

	public void run()
	{
		System.out.println("flag=" + flag);
		if (flag == 1)
		{
			synchronized (o1)
			{
				try
				{
					Thread.sleep(500);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				synchronized (o2)
				{
					System.out.println("1");
				}
			}
		}
		if (flag == 0)
		{
			synchronized (o2)
			{
				try
				{
					Thread.sleep(500);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				synchronized (o1)
				{
					System.out.println("0");
				}
			}
		}
	}

	public static void main(String[] args)
	{
		TestDeadLock td1 = new TestDeadLock();
		TestDeadLock td2 = new TestDeadLock();
		td1.flag = 1;
		td2.flag = 0;
		Thread t1 = new Thread(td1);
		Thread t2 = new Thread(td2);
		t1.start();
		t2.start();
	}
}