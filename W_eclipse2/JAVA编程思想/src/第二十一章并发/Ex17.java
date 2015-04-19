/**
 * �ļ�����Ex17.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-6
 */
package �ڶ�ʮһ�²���;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ���ĵ�
 * ������Ex17
 * ��˵����
 */
class Count
{
	private int count = 0;
	private Random rand = new Random(47);
	public synchronized int incremrnt()
	{
		int temp = count;
		if(rand.nextBoolean())
			Thread.yield();
		return (count = ++temp);
	}
	public synchronized int value() {return count ;}
}
class Entrance implements Runnable
{
	private static Count count = new Count();
	private static List<Entrance> entrances = new ArrayList<Entrance>();
	private int number = 0;
	private final int id;
	private static volatile boolean canceled = false ;
	public static void cancel() {canceled = true;}
	public Entrance(int id){
		this.id = id;
		entrances.add(this);
	}
	public void run()
	{
		while(!canceled){
			synchronized (this)
			{
				++number;
			}
			System.out.println(this+ "Total: "+count.incremrnt());
			try
			{
				TimeUnit.MILLISECONDS.sleep(100);
			}
			catch (InterruptedException e)
			{
				System.out.println("Sleep interrupted");
			}
		}
		System.out.println("Stoping + this");
	}
	public synchronized int getvalue() {return number;}
	public String toString()
	{
		return "Entrance" +id +": "+getvalue();
	}
	public static int getTotalCount()
	{
		return count.value();
	}
	public static int sumEntrances(){
		int sum = 0;
		for(Entrance entrance :entrances)
			sum += entrance.getvalue();
		return sum;
	}
}
public class Ex17
{
	public static void main(String args[]) throws Exception
	{
		Random random = new Random(47);
		ExecutorService exec = Executors.newCachedThreadPool();
		int k = random.nextInt(1000);  //1000 �����ڵ�  ����������� ~~~
		for(int i = 0;i<k ;i++)
			exec.execute(new Entrance(i));
		TimeUnit.SECONDS.sleep(2);   //�� 
		Entrance.cancel();
		exec.shutdown();
		if(!exec.awaitTermination(1000, TimeUnit.MILLISECONDS))
			System.out.println("!!!!!!!!!!!!!!!!!");
		System.out.println("Total: "+Entrance.getTotalCount() );
		System.out.println("Sum of Entrance: "+Entrance.sumEntrances());
	}
}
