/**
 * �ļ�����Ex11.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-5
 */
package �ڶ�ʮһ�²���;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ���ĵ�
 * ������Ex11
 * ��˵����  ���ɹ�Ҳ ������ʾ�� �����е�  ����++ �ķ�ԭ���� ~~~���� 
 */
public class Ex11
{
	public static void main(String args[])
	{

			for(int i = 0;i<10;i++)
			{
				ExecutorService exec = Executors.newCachedThreadPool();
				exec.execute(new myClass11());
				Thread.yield();
				exec.shutdown();
			}
		
	}
}
class myClass11 implements Runnable
{
	private  int p1 = 0;
	private  int p2 = 0;
	public int haha11() 
	{
		while(true)
		{
			++p1 ;
			Thread.yield();
			++p1 ;
			Thread.yield();
			++p2 ;
			Thread.yield();
			++p2 ;
			return p1+p2;
		}
	}
	public int getvalue() {return p1+p2 ;}
	public void run()
	{
		while(true)
		{
			int  k = getvalue();
			k = haha11();
			if(k % 2 !=0)
			{
				System.out.println(k);
				break ;
			}
		}
	}
}
