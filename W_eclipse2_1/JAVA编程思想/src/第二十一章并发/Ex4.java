/**
 * �ļ�����Ex4.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-4
 */
package �ڶ�ʮһ�²���;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ��ʮ���·���.Fibonacci7;

/**
 * @author ���ĵ�
 * ������Ex4
 * ��˵����
 */
public class Ex4
{
	public static void main(String args[])
	{
		ExecutorService exec1 = Executors.newCachedThreadPool();
		//for(int i =1;i<=7;i++)
		//	exec1.execute(new Fibonacci(i));
		
		ExecutorService exec2 = Executors.newFixedThreadPool(5);
		//for(int i =1;i<=5;i++)
			//exec2.execute(new Fibonacci(i));
		
		ExecutorService exec3 = Executors.newSingleThreadExecutor();
		for(int i =1;i<6;i++)
			exec3.execute(new Fibonacci(i));
	}
}
