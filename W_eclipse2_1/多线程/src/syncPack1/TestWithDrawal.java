/**
 * 文件名：TestWithDrawal.java
 * 项目-包：多线程 - syncPack1
 * 作者：张文迪
 * 创建日期：2014-5-23
 */
package syncPack1;

/**
 * @author 张文迪
 * 类名：TestWithDrawal
 * 类说明：
 */


/*解决的办法：当有线程执行timer对象的时候，锁定当前对象 ；
  一种synchronized放在方法中，在执行该方法过程当中当前对象被锁定
 另外一种：synchronized放在方法体中
 缺点：效率会降低
 优点：解决数据前后不一致的现象
 */
public class TestWithDrawal
{
	static Account account = new Account();

	public static void main(String[] args)
	{
		Counter counter = new Counter(account,1500);
		ATM atm = new ATM(account, 1500);
		Thread t1 = new Thread(counter);
		Thread t2 = new Thread(atm);
		
		t1.setName("小明");
		t2.setName("小明老婆");
		t1.start();
		t2.start();
	}
}

/**
 * @author eagler_hu
 * 类名：Counter
 * 类说明：柜台线程类
 */
class Counter implements Runnable
{
    Account account;
    int num;
	
    public Counter(Account account,int numOfDrawing)
    {
    	this.account = account;
    	num = numOfDrawing;
    }
    
	public void run()
	{
		//synchronized (account)
		//{
			if(account.getMoney()>=num)
			{
				 int tempNum = 0;
				 System.out.println(Thread.currentThread().getName() + "取走了" + num+"元");
				 tempNum = account.getMoney()-num;
			     account.updateAccount(Thread.currentThread().getName(),tempNum);
			     System.out.println("你的余额为："+account.getMoney());
			}
			else
				System.out.println("余额不足!");
		//}
	}
}

/**
 * @author eagler_hu
 * 类名：ATM
 * 类说明：ATM机线程类
 */
class ATM implements Runnable
{
    Account account;
    int num;
	
    public ATM(Account account,int numOfDrawing)
    {
    	this.account = account;
    	num = numOfDrawing;
    }
    
	public void run()
	{
		//synchronized (account)
		//{
			if(account.getMoney()>=num)
			{
				 int tempNum = 0;
				 System.out.println(Thread.currentThread().getName() + "取走了" + num+"元");
				 tempNum = account.getMoney()-num;
			     account.updateAccount(Thread.currentThread().getName(),tempNum);
			     System.out.println("你的余额为："+account.getMoney());
			}
			else
				System.out.println("余额不足!");
		//}
	}
}

class Account
{
	private static int savings = 2000;

	public void updateAccount(String name,int updateNum)
	{
		try
		{
			Thread.sleep(1);  //sleep的时候不释放锁
		}
		catch (InterruptedException e)
		{
		}
		savings = updateNum;
	}
	
	public int getMoney()
	{
		return savings;
	}
}

