/**
 * 文件名：Ex24.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-7
 */
package 第二十一章并发;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 张文迪
 * 类名：Ex24
 * 类说明：用到了 泛型，队列..... 精髓了 ~~~
 */
class FlowQueue<T> 
{
	private Queue<T> queue = new LinkedList<T>();
	private int maxSize;
	public FlowQueue(int maxSize) { this.maxSize = maxSize; }
	public synchronized void put(T v) throws InterruptedException 
	{
		while(queue.size() >= maxSize)
			wait();
		queue.offer(v);  //将指定的元素插入此队列
		maxSize++;
		notifyAll();
	}
	public synchronized T get() throws InterruptedException 
	{
		while(queue.isEmpty())
			wait();
		T returnVal = queue.poll(); //获取并移除此队列的头，如果此队列为空
		maxSize--;
		notifyAll();
		return returnVal;
	}
}
class Item 
{
	private static int counter;
	private int id = counter++;
	public String toString() { return "Item " + id; }
}// Produces Item objects
	
class Producer implements Runnable 
{
	private int delay;
	private FlowQueue<Item> output;
	public Producer(FlowQueue<Item> output, int sleepTime) 
	{
		this.output = output;
		delay = sleepTime;
	}
	public void run() 
	{
		for(;;) {
			try {
				output.put(new Item());
				TimeUnit.MILLISECONDS.sleep(delay);
			} catch(InterruptedException e) { return; }
		}
	}
}// Consumes any object
	
class Consumer implements Runnable 
{
	private int delay;
	private FlowQueue<?> input;
	public Consumer(FlowQueue<?> input, int sleepTime) 
	{
		this.input = input;
		delay = sleepTime;
	}
	public void run()
	{
		for(;;) 
		{
			try 
			{
				System.out.println(input.get());
				TimeUnit.MILLISECONDS.sleep(delay);
			} catch(InterruptedException e) { return; }
		}
	}
}
public class Ex24 
{
	public static void main(String[] args) throws Exception 
	{
		if(args.length < 2) {
			System.err.println("Usage java E24_ProducerConsumer" +
			" <producer sleep time> <consumer sleep time>");
			System.exit(1);
		}
		int producerSleep = Integer.parseInt(args[0]);
		int consumerSleep = Integer.parseInt(args[1]);
		
		
		FlowQueue<Item> fq = new FlowQueue<Item>(100);
		ExecutorService exec = Executors.newFixedThreadPool(2);
		exec.execute(new Producer(fq, producerSleep));
		exec.execute(new Consumer(fq, consumerSleep));
		TimeUnit.SECONDS.sleep(2);
		exec.shutdownNow();
	}
}
