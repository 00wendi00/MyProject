/**
 * �ļ�����CFirstThread.java
 * ��Ŀ-�������߳� - firstFeelPack
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-23
 */
package firstFeelPack;

/**
 * @author ���ĵ�
 * ������CFirstThread
 * ��˵����
 */

/**
 * �̳߳�����
 * @author eagler_hu
 *
 */
class MyThread1 implements Runnable
{

	@Override
	public void run()
	{
        for (int i = 0; i <1000; i++)
		{
			System.out.println("my thread:"+i);
		}
	}
}

public class CFirstThread
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
           //MyThread thr = new MyThread();
           //thr.start();  //����һ���̣߳����Զ����õ��̵߳�run������
		   MyThread1 thread1 = new MyThread1();
		   Thread thr = new Thread(thread1);
		   thr.start();
           
           for (int i = 0; i <1000; i++)
   		   {
   			    System.out.println("main:"+i);
   		   }
	}

}

