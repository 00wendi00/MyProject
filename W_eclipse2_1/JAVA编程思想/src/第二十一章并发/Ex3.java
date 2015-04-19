/**
 * 文件名：Ex3.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-4
 */
package 第二十一章并发;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 张文迪
 * 类名：Ex3
 * 类说明：
 */
public class Ex3
{
	public static void main(String args[])
	{
		ExecutorService exec1 = Executors.newCachedThreadPool();
		//for(int i =0;i<4;i++)
			//exec1.execute(new MyThread());
		
		ExecutorService exec2 = Executors.newFixedThreadPool(5); 
										//参数为1     的时候和     newSingleThreadExecutor一样了~~  
		//for(int i=0;i<5;i++)
			//exec2.execute(new MyThread());
		
		ExecutorService exec3 = Executors.newSingleThreadExecutor();
		for(int i=0;i<4;i++)
			exec3.execute(new MyThread());
	}
}
