/**
 * �ļ�����Ex3.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-4
 */
package �ڶ�ʮһ�²���;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ���ĵ�
 * ������Ex3
 * ��˵����
 */
public class Ex3
{
	public static void main(String args[])
	{
		ExecutorService exec1 = Executors.newCachedThreadPool();
		//for(int i =0;i<4;i++)
			//exec1.execute(new MyThread());
		
		ExecutorService exec2 = Executors.newFixedThreadPool(5); 
										//����Ϊ1     ��ʱ���     newSingleThreadExecutorһ����~~  
		//for(int i=0;i<5;i++)
			//exec2.execute(new MyThread());
		
		ExecutorService exec3 = Executors.newSingleThreadExecutor();
		for(int i=0;i<4;i++)
			exec3.execute(new MyThread());
	}
}
