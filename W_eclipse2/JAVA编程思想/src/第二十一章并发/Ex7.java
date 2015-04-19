/**
 * �ļ�����Ex7.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-5
 */
package �ڶ�ʮһ�²���;

import java.util.concurrent.TimeUnit;

/**
 * @author ���ĵ�
 * ������Ex7
 * ��˵���� main()�˳� ���̨�߳̾����ˣ�
 */
class Daemon implements Runnable{
	private Thread[] t = new Thread[1000];
	public void run(){
		for(int i = 0;i<t.length;i++)
		{
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DaemonSpawn "+ i +" Started, ");
		}
		for(int i =0;i<t.length;i++)
			System.out.println("t["+i+"].isDaemon = "+ t[i].isDaemon()+" ,");
		while(true)
			Thread.yield();
	}
}
class DaemonSpawn implements Runnable{
	public void run(){
		while(true)
			Thread.yield();
	}
}
public class Ex7
{
	public static void main(String args[]) throws Exception
	{
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		System.out.println("d.isDaemon = " +d.isDaemon()+" , ");
		TimeUnit.MILLISECONDS.sleep(100);
	}
}
