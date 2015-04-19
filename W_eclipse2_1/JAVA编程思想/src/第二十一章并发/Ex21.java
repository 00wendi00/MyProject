/**
 * �ļ�����Ex21.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-6
 */
package �ڶ�ʮһ�²���;

import static net.mindview.util.Print.print;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ���ĵ�
 * ������Ex21
 * ��˵�����������Ҳ�Ǿ���~~~synchronized�÷�Ҳ�Ǽ��õ� ������
 */
class Coop1 implements Runnable 
{
	public Coop1() { print("Constructed Coop1"); }
	public void run() 
	{
		print("Coop1 going into wait");
		synchronized(this)               // ���ܶ�����������synchronized~~   ��Ӧ�������ã�����
		{
			try {
				wait();
				System.out.println("!!!!!!!!!");
			} catch(InterruptedException ignore) {}
		}
		print("Coop1 exited wait");
	}
}
class Coop2 implements Runnable 
{
	Runnable otherTask;
	public Coop2(Runnable otherTask) 
	{
		this.otherTask = otherTask;
		print("Constructed Coop2");
	}
	public void run() 
	{
		print("Coop2 pausing 5 seconds");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch(InterruptedException ignore) {}
		print("Coop2 calling notifyAll");
		synchronized(otherTask) { otherTask.notifyAll(); }      // �ɶ���(coop1)�����������ˣ� Ȼ���� coop1
															   // ̫������ ~~~
	}
}
public class Ex21 
{
	public static void main(String args[]) throws Exception
	{
		Runnable coop1 = new Coop1(),
		coop2 = new Coop2(coop1);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(coop1);
		exec.execute(coop2);
		Thread.yield();  // �������~~���岻��
		exec.shutdown();
	}
}
