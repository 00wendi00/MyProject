/**
 * 文件名：Ex14.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-5
 */
package 第二十一章并发;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


/**
 * @author 张文迪
 * 类名：Ex14
 * 类说明：  args[0] = 55555555 就痿了， 很大个球~~
 */
public class Ex14 
{
	public static void main(String[] args) throws Exception 
	{
		if(args.length < 1) 
		{
			System.err.println(
			"Usage: java E14_ManyTimers <num of timers>");
		}
		int numOfTimers = Integer.parseInt(args[0]);
		for(int i = 0; i < numOfTimers; i++) 
		{
			new Timer().schedule(new TimerTask()    //创建一个新计时器。相关的线程不 作为守护程序运行。 
			{         //安排在指定延迟后执行指定的任务。  参数为  安排的任务 ，时间。
				public void run() {
					System.out.println(System.currentTimeMillis());
				}
			}, numOfTimers - i);
		}
		// Wait for timers to expire
		TimeUnit.MILLISECONDS.sleep(2 * numOfTimers);
		//TimeUnit 表示给定单元粒度的时间段，它提供在这些单元中进行跨单元转换和执行计时及延迟操作的实用工具方法
		System.exit(0);
	}
}
