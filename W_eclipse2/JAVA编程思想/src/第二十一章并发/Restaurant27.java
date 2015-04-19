/**
 * �ļ�����Ex27.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-7
 */
package �ڶ�ʮһ�²���;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ���ĵ�
 * ������Ex27
 * ��˵���� ����ʾ�� lock�� Condition  �����߳�֮���Э��������
 */
class Meal0{
	private final int orderNum;
	public Meal0(int orderNum) {this.orderNum = orderNum;}
	public String toString() {return "Meal " +orderNum;}
}
class WaitPerson0 implements Runnable{
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private Restaurant27 restaurant ;
	public WaitPerson0(Restaurant27 r) {restaurant = r;}
	public void run(){
		try
		{
			while(!Thread.interrupted()){
				synchronized(this){
					while(restaurant.meal==null)
						condition.await();
				}
				System.out.println("Waitperson got" + restaurant.meal);
				lock.lock();
				try{
					condition.notifyAll();
				}finally{
					lock.unlock();
				}
				lock.lock();
				try{
					restaurant.meal = null;
					condition.notifyAll();
				}finally{
					lock.unlock();
				}
				
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("WaitPerson interrupted");
		}
	}
}
class BusBoy0 implements Runnable
{
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private Restaurant27 restaurant ;
	public BusBoy0(Restaurant27 r) {restaurant = r;}
	public void run(){
		try
		{
			while(!Thread.interrupted()){
				lock.lock();
				try{
					condition.await();
					System.out.println("������~~~~~");
				}finally{
					lock.unlock();
				}
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("boy interrupted");
		}
	}
}
class Chef0 implements Runnable{
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private Restaurant27 restaurant ;
	private int count = 0;
	public Chef0(Restaurant27 r) {restaurant = r;}
	public void run(){
		try
		{
			while(!Thread.interrupted()){
				lock.lock();
				try{
					while(restaurant.meal != null)
						condition.await();
				}finally{
					lock.unlock();
				}
				if(++count == 10){
					System.out.println("out of food ,Closing");
					restaurant.exec.shutdownNow();
				}
				System.out.print("Order up!!!!!");
				lock.lock();
				try{
					restaurant.meal = new Meal0(count);
					condition.notifyAll();
				}finally{
					lock.unlock();
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

public class Restaurant27
{
	Meal0 meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson0 waitPerson = new WaitPerson0(this);
	Chef0 chef = new Chef0(this);
	BusBoy0 boy = new BusBoy0(this);   // this���÷��� ������~~~
	public Restaurant27(){
		exec.execute(chef);
		exec.execute(waitPerson);
		exec.execute(boy);
	}
	public static void main(String[] args){
		new Restaurant2425();
	}
}
