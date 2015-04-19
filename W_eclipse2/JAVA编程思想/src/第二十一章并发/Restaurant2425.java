/**
 * �ļ�����Ex2425.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-7
 */
package �ڶ�ʮһ�²���;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ���ĵ�
 * ������Ex2425
 * ��˵����  �������  ��̫���棻 ��ȥ����İɣ�
 */
class Meal{
	private final int orderNum;
	public Meal(int orderNum) {this.orderNum = orderNum;}
	public String toString() {return "Meal " +orderNum;}
}
class WaitPerson implements Runnable{
	private Restaurant2425 restaurant ;
	public WaitPerson(Restaurant2425 r) {restaurant = r;}
	public void run(){
		try
		{
			while(!Thread.interrupted()){
				synchronized(this){
					while(restaurant.meal==null)
						wait();
				}
				System.out.println("Waitperson got" + restaurant.meal);
				synchronized (restaurant.boy)
				{
					restaurant.boy.notifyAll();
				}
				synchronized (restaurant.chef)
				{
					restaurant.meal = null;
					restaurant.chef.notifyAll();
				}
				
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("WaitPerson interrupted");
		}
	}
}
class BusBoy implements Runnable
{
	private Restaurant2425 restaurant ;
	public BusBoy(Restaurant2425 r) {restaurant = r;}
	public void run(){
		try
		{
			while(!Thread.interrupted()){
				synchronized (this)
				{
					wait();
					System.out.println("������~~~~~");
				}
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("boy interrupted");
		}
	}
}
class Chef implements Runnable{
	private Restaurant2425 restaurant ;
	private int count = 0;
	public Chef(Restaurant2425 r) {restaurant = r;}
	public void run(){
		try
		{
			while(!Thread.interrupted()){
				synchronized (this)
				{
					while(restaurant.meal != null)
						wait();
				}
				if(++count == 10){
					System.out.println("out of food ,Closing");
					restaurant.exec.shutdownNow();
				}
				System.out.print("Order up!!!!!");
				synchronized (restaurant.waitPerson)
				{
					restaurant.meal = new Meal(count);
					restaurant.waitPerson.notifyAll();
				}
				TimeUnit.MILLISECONDS.sleep(100);
				//24�⣺��������ͼ����һ����������ʱ������ж�ֻ��  �׳�  interruptedException��
				//�Ƴ�sleep()�����񽫻ص�run()ѭ���Ķ�������������Thread.interruped()���Զ��˳������׳��쳣~~~
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("Chef interrupted");
		}
	}
}

public class Restaurant2425
{
	Meal meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);
	BusBoy boy = new BusBoy(this);   // this���÷��� ������~~~
	public Restaurant2425(){
		exec.execute(chef);
		exec.execute(waitPerson);
		exec.execute(boy);
	}
	public static void main(String[] args){
		new Restaurant2425();
	}
}
