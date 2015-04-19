/**
 * 文件名：Ex31.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-7
 */
package 第二十一章并发;

/**
 * @author 张文迪
 * 类名：Ex31
 * 类说明：  never 死锁~~~
 */
import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.Print.*;
class Chopstick 
{
	private final int id;
	private boolean taken;
	public Chopstick(int ident) { id = ident; }
	public synchronized
	void take() throws InterruptedException {
		while(taken)
			wait();
		taken = true;
	}
	public synchronized void drop() {
		taken = false;
		notifyAll();
	}
	public String toString() { return "Chopstick " + id; }
}
class ChopstickQueue extends LinkedBlockingQueue<Chopstick>{}class ChopstickBin
	{
		private ChopstickQueue bin = new ChopstickQueue();
		public Chopstick get() throws InterruptedException {
			return bin.take();
		}
		public void
		put(Chopstick stick) throws InterruptedException {
			bin.put(stick);
		}
	}
class Philosopher implements Runnable 
{
	private static Random rand = new Random(47);
	private final int id;
	private final int ponderFactor;
	private ChopstickBin bin;
	private void pause() throws InterruptedException {
		if(ponderFactor == 0) return;
		TimeUnit.MILLISECONDS.sleep(
				rand.nextInt(ponderFactor * 250));
	}
	public Philosopher(ChopstickBin bin, int ident,int ponder) {
		this.bin = bin;
		id = ident;
		ponderFactor = ponder;
	}
	public void run() {
		try {
			while(!Thread.interrupted()) {
				print(this + " " + "thinking");
				pause();
				// Get one chopstick from the bin
				Chopstick c1 = bin.get();
				print(this + " has " + c1 +
				" waiting for another one");
				// Get another chopstick from bin
				Chopstick c2 = bin.get();
				print(this + " has " + c2);
				print(this + " eating");
				pause();
				// Put the chopsticks back in bin.
				bin.put(c1);
				bin.put(c2);
			}
		} catch(InterruptedException e) {
			print(this + " " + "exiting via interrupt");
		}
	}
	public String toString() { return "Philosopher " + id; }
	}public class Ex31 {
		public static void main(String[] args) throws Exception {
			if(args.length < 3) {

				System.err.println("usage:\n" +
"java E31_DiningPhilosophers2 " +
"numberOfPhilosophers ponderFactor deadlock " +
"timeout\n" + "A nonzero ponderFactor will " +
"generate a random sleep time during think().\n" +
"If deadlock is not the string " +
"'deadlock', the program will not deadlock.\n" +
"A nonzero timeout will stop the program after " +
"that number of seconds.");
				System.exit(1);
			}
			ChopstickBin bin = new ChopstickBin();
			int size = Integer.parseInt(args[0]);
			int ponder = Integer.parseInt(args[1]);
			for(int i = 0; i < size; i++)
				bin.put(new Chopstick(i));
			// One additional chopstick guarantees that at least
			// one philosopher can eat without blocking.
			if(!args[2].equals("deadlock"))
				bin.put(new Chopstick(size));
			ExecutorService exec = Executors.newCachedThreadPool();
			for(int i = 0; i < size; i++)
				exec.execute(new Philosopher(bin, i, ponder));
			if(args.length == 4)
				TimeUnit.SECONDS.sleep(Integer.parseInt(args[3]));
			else {
				print("Press 'ENTER' to quit");
				System.in.read();
			}
			exec.shutdownNow();
		}
}