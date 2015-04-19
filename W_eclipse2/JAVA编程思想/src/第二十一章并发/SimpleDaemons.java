/**
 * �ļ�����SimpleDaemons.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-5
 */
package �ڶ�ʮһ�²���;

import java.util.concurrent.TimeUnit;

/**
 * @author ���ĵ�
 * ������SimpleDaemons
 * ��˵���� Thread.setDaemon(boolean);  ��̨�߳�~~
 */
public class SimpleDaemons implements Runnable
{
	public void run(){
		try
		{
			while(true){
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.println(Thread.currentThread()+" "+this);   //���ضԵ�ǰ����ִ�е��̶߳��������
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("Sleep() interrupted");
		}
	}
	public static void main(String args[]) throws Exception
	{
		for(int i =0;i<10;i++){
			Thread deamon = new Thread(new SimpleDaemons());
			deamon.setDaemon(true);
			deamon.start();
		}
		System.out.println("All start");
		TimeUnit.MILLISECONDS.sleep(5000);   //ִ��5���main()�߳̽�������̨�߳�ͬʱ��ֹ~~
	}
}
