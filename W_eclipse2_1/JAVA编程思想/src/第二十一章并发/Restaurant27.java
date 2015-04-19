/**
 * 文件名：Ex27.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-7
 */
package 第二十一章并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 张文迪
 * 类名：Ex27
 * 类说明： 用显示的 lock和 Condition  进行线程之间的协作！！！
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
					System.out.println("清理了~~~~~");
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
				//24题：当任务试图进入一个阻塞操作时，这个中断只能  抛出  interruptedException。
				//移除sleep()后，任务将回到run()循环的顶部，并且由于Thread.interruped()测试而退出，不抛出异常~~~
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
	BusBoy0 boy = new BusBoy0(this);   // this的用法， 很神奇~~~
	public Restaurant27(){
		exec.execute(chef);
		exec.execute(waitPerson);
		exec.execute(boy);
	}
	public static void main(String[] args){
		new Restaurant2425();
	}
}
