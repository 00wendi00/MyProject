/**
 * 文件名：AtomiccityTest.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-5
 */
package 第二十一章并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 张文迪
 * 类名：AtomiccityTest
 * 类说明：练习12 ~~~能证明synchronized修饰了几个方法后         是 安全的  ： 
 *     	           ！！！！对于某个特定对象~synchronized方法共享同一个锁~防止多个任务同时访问被编码为对象内存---
 *     	           ！！！！可以多次获得锁++  每次离开的时候 --   计数最终为0
 *         ！！！！当只有一个synchronized方法的时候，如果有超过一个方法处在临界数据~，
 *         则这个 方法的synchronized将会被随意忽略，故必须同步所有的相关方法，如这个题目
 */
public class AtomiccityTest implements Runnable
{
	private int i = 0;
	public synchronized int getvalue() {return i ;}
	private synchronized void evenIncrement() {i++;i++;}
	public void run(){
		while(true)
			evenIncrement();
	}
	public static void main(String args[]){
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomiccityTest at = new AtomiccityTest();
		exec.execute(at);
		while(true){
			int val = at.getvalue();
			if(val%2 !=0)
			{
				System.out.println(val);
				System.exit(0);
			}
		}
	}
}
