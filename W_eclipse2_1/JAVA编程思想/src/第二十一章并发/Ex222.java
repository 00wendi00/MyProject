/**
 * �ļ�����Ex222.java
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
 * ������Ex222
 * ��˵�������� synchronized ʵ��ͬ������~~
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
						
						synchronized(this) { notify(); }  // ���� synchronized ʵ��ͬ������~~
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