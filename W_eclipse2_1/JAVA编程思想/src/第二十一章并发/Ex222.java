/**
 * 文件名：Ex222.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-6
 */
package 第二十一章并发;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 张文迪
 * 类名：Ex222
 * 类说明：利用 synchronized 实现同步控制~~
 */
public class Ex222 
{
	volatile static int k =0 ;
	public static void main(String[] args) throws Exception 
	{ 
		
		final Runnable r1 = new Runnable() {
			public void run() {
				for(;;) {
					try {
						TimeUnit.MILLISECONDS.sleep(200);
						
						synchronized(this) { notify(); }  // 利用 synchronized 实现同步控制~~
					} catch(InterruptedException e) { return; }
				}
			}
		};
		Runnable r2 = new Runnable() {
			public void run() {
				for(;;) {
					try {
						synchronized(r1) {
							k++;
							r1.wait(); 
						}
					} catch(InterruptedException e) { return; }
					System.out.print("Cycled "+k+" ");
				}
			}
		};
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(r1);
		exec.execute(r2);
		TimeUnit.SECONDS.sleep(2);
		exec.shutdownNow();
	}
}