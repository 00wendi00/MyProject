/**
 * �ļ�����CThreadAlive.java
 * ��Ŀ-�������߳� - ��ʦ����
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-23
 */
package thrMethodPack;

import firstFeelPack.MyThread1;

/**
 * @author ���ĵ�
 * ������CThreadAlive
 * ��˵����
 */

/**
 * �̸߳��ַ�����ʹ��isActive��
 * 
 * @author eagler_hu
 * 
 */
public class CThreadAlive
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		MyThread1 t = new MyThread1("aa");
		t.start(); //����һ���̣߳����Զ����õ��̵߳�run������

		/**
		 * ���t�̴߳��ڻ��״̬��������ִ�У��Ӷ�����ʵ�������߳�ͬ����
		 */
		while (t.isAlive())
		{

		}

		for (int i = 0; i < 10; i++)
		{
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}
