/**
 * 文件名：Ex2425.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-7
 */
package 第二十一章并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 张文迪
 * 类名：Ex2425
 * 类说明：  这个锁啊  ，太神奇； 我去你妈的吧！
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
					System.out.println("清理了~~~~~");
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

public class Restaurant2425
{
	Meal meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);
	BusBoy boy = new BusBoy(this);   // this的用法， 很神奇~~~
	public Restaurant2425(){
		exec.execute(chef);
		exec.execute(waitPerson);
		exec.execute(boy);
	}
	public static void main(String[] args){
		new Restaurant2425();
	}
}
