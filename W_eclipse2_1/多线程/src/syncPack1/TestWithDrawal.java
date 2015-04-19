/**
 * �ļ�����TestWithDrawal.java
 * ��Ŀ-�������߳� - syncPack1
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-23
 */
package syncPack1;

/**
 * @author ���ĵ�
 * ������TestWithDrawal
 * ��˵����
 */


/*����İ취�������߳�ִ��timer�����ʱ��������ǰ���� ��
  һ��synchronized���ڷ����У���ִ�и÷������̵��е�ǰ��������
 ����һ�֣�synchronized���ڷ�������
 ȱ�㣺Ч�ʻή��
 �ŵ㣺�������ǰ��һ�µ�����
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
		
		t1.setName("С��");
		t2.setName("С������");
		t1.start();
		t2.start();
	}
}

/**
 * @author eagler_hu
 * ������Counter
 * ��˵������̨�߳���
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
				 System.out.println(Thread.currentThread().getName() + "ȡ����" + num+"Ԫ");
				 tempNum = account.getMoney()-num;
			     account.updateAccount(Thread.currentThread().getName(),tempNum);
			     System.out.println("������Ϊ��"+account.getMoney());
			}
			else
				System.out.println("����!");
		//}
	}
}

/**
 * @author eagler_hu
 * ������ATM
 * ��˵����ATM���߳���
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
				 System.out.println(Thread.currentThread().getName() + "ȡ����" + num+"Ԫ");
				 tempNum = account.getMoney()-num;
			     account.updateAccount(Thread.currentThread().getName(),tempNum);
			     System.out.println("������Ϊ��"+account.getMoney());
			}
			else
				System.out.println("����!");
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
			Thread.sleep(1);  //sleep��ʱ���ͷ���
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

