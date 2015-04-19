/**
 * �ļ�����Ex6.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-4
 */
package �ڶ�ʮһ�²���;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ���ĵ�
 * ������Ex6
 * ��˵����       TimeUnit.MILLISECONDS.sleep(1000);	 ������̵߳����� ��   ����� ���� �� ������ ��������
 */
public class Ex6
{	
	public static void main(String args[])
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i =0;i<4;i++)
			exec.execute(new MyThread6());
	}
}
class MyThread6 implements Runnable
{
	int i = 5;
	private static int count = 0;
	private final int id = count++ ;
	MyThread6()
	{
		System.out.println("#"+id+"#"+"������!!!");
	}
	public String status()
	{
		return "#"+id+"#: "+(i>0? i:"������ ");
	}
	public void run()
	{
		Random random = new Random(47);
		int p = 0;	
		try
		{
			while(i-->0){							
				System.out.println(status());							
				p = random.nextInt(1000);   
				System.out.println(p);
				TimeUnit.MILLISECONDS.sleep(p);			  // ���� һ�����ڵ�ʱ��(�����)				
			}
			System.out.println("�����ˣ�����");
		}
		catch (InterruptedException e) {
			System.err.println("Interrupt"); 
		}
	}
}
