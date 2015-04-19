/**
 * 文件名：PipedIO.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-7
 */
package 第二十一章并发;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


/**
 * @author 张文迪
 * 类名：PipedIO
 * 类说明：修改PipedIO 用  BlockingQueue~~~
 */
class Sender implements Runnable{
	private Random rand = new Random(47);
	BlockingQueue<Character> senders;
	Sender(BlockingQueue<Character> senders) {this.senders = senders;}
	public void run(){
		try
		{
			while(true){
				for(char c = 'A';c<='z';c++)
				{
					senders.put(c);
					TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				}
			}
		}catch (InterruptedException e) {
			
			System.out.println(e+"Senders sleep interruped");
		}
	}
}
class Receiver implements Runnable{
	BlockingQueue<Character> senders;
	Receiver(BlockingQueue<Character> senders) {
		this.senders = senders;
	}
	public void run(){
		try
		{
			while(true){
				System.out.print("Read "+senders.take().toString()+", ");
			}
		}catch (InterruptedException e) {
			System.out.println();
			System.out.println(e+ "Receiver is interrupted");
		}	
	}
}


public class Ex30
{
	public static void main(String args[]) throws Exception
	{
		BlockingQueue<Character> queue = new LinkedBlockingQueue<Character>();
		Sender sender = new Sender(queue);
		Receiver receiver = new Receiver(queue);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(sender);
		exec.execute(receiver);
		TimeUnit.SECONDS.sleep(2);	
		exec.shutdownNow();
	}
}
