/**
 * �ļ�����Ex221.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-6
 */
package �ڶ�ʮһ�²���;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ���ĵ�
 * ������Ex221
 * ��˵����
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
		exec.shutdownNow(); //��ͼֹͣ��������ִ�еĻ������ͣ�������ڵȴ������񣬲����صȴ�ִ�е������б�
	}
}
