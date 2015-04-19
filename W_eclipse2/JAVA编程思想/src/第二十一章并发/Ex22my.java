/**
 * �ļ�����Ex22.java
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
 * ������Ex22
 * ��˵���� �ҵ�������Ӹ㶨��       ��  ���ͨ�����þ�̬���� ���õ�&������ b     ~~~  
 * 				                 ��  volatile������� b�ǵĶ�ȡb��֮ǰ��֪����b��д��
 */
class Fool1 implements Runnable{
	volatile static boolean b = false;
	static boolean getb(){
		return b;
	}
	static  void setb(boolean c){
		b = !c;
	}
	public  void run(){
		try
		{
			TimeUnit.SECONDS.sleep(3);
			b = true;
			System.out.println(b);
		}
		catch (InterruptedException e)
		{
			// TODO: handle exception
		}
	}
}
class Fool2 implements Runnable{
	public void run(){
		while(!Thread.interrupted()) {
			if(Fool1.getb()==true)
			{
				System.out.println("!!!!!!!!!!");
				Fool1.setb(Fool1.getb());	
			}
		}	
	}
}

public class Ex22my
{
	public static void main(String args[]) throws Exception
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Fool1());
		exec.execute(new Fool2());
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}
}
