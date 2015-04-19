/**
 * 文件名：Ex221.java
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
 * 类名：Ex221
 * 类说明：
 */
public class Ex221 
{
	private static volatile boolean flag;
	private static int spins;
	public static void main(String[] args) throws Exception {
		Runnable r1 = new Runnable() {
			public void run() {
				for(;;) {
					try {
						TimeUnit.MILLISECONDS.sleep(10);
					} catch (InterruptedException e) { return; }
					flag = true;
				}
			}
		};
		Runnable r2 = new Runnable() {
			public void run() {
				for(;;) {
					// The busy-wait loop
					while(!flag && !Thread.currentThread().isInterrupted())
						spins++;
					System.out.println("Spun " + spins + " times");
					spins = 0;
					flag = false;
					if(Thread.interrupted())
						return;
				}
			}
		};
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(r1);
		exec.execute(r2);
		TimeUnit.SECONDS.sleep(1);
		exec.shutdownNow(); //试图停止所有正在执行的活动任务，暂停处理正在等待的任务，并返回等待执行的任务列表
	}
}
