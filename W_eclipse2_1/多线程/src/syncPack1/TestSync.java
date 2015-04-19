/**
 * 文件名：TestSync.java
 * 项目-包：多线程 - syncPack1
 * 作者：张文迪
 * 创建日期：2014-5-23
 */
package syncPack1;

/**
 * @author 张文迪
 * 类名：TestSync
 * 类说明：
 */

/*解决的办法：当有线程执行timer对象的时候，锁定当前对象 ；
  一种synchronized放在方法中，在执行该方法过程当中当前对象被锁定
 另外一种：synchronized放在方法体中
 缺点：效率会降低
 优点：解决数据前后不一致的现象
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
	  //synchronized (this)  //锁住当前对象
	  //{
		num++;
		try
		{
			Thread.sleep(1);  //sleep的时候不释放锁
		}
		catch (InterruptedException e)
		{
		}
		System.out.println(name + ", 你是第" + num + "个使用timer对象的线程");
	 //}
	}
}

