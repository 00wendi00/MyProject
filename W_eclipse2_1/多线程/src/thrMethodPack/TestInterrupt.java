/**
 * �ļ�����TestInterrupt.java
 * ��Ŀ-�������߳� - thrMethodPack
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-23
 */
package thrMethodPack;

/**
 * @author ���ĵ�
 * ������TestInterrupt
 * ��˵����
 */


import java.util.*;

public class TestInterrupt
{
	static boolean flag;
	public static void main(String[] args)
	{
		MyThread thread = new MyThread();
		thread.start();
		try
		{
			Thread.sleep(10000);
		}
		catch (InterruptedException e)
		{
		}
		//thread.interrupt();  //�Ƚϴֱ����мɲ�Ҫ��stop�����Ӵֱ�
		flag =false;
	}
}

class MyThread extends Thread
{
	

	public void run()
	{
		boolean flag = true;  //�ȽϺõ�ֹͣ�̵߳ķ�����
		while (flag)
		{
			System.out.println("===" + new Date() + "===");
			try
			{
				sleep(1000);
			}
			catch (InterruptedException e)
			{
				return;
			}
		}
	}
}
/*
 * public void run() { while (true) { String temp = new Date().toString();
 * String t = temp.substring(11, temp.indexOf('C')); t = t.trim(); String[] time
 * = t.split(":"); if (time.length == 3) { System.out.println(�������ǡ� + time[0] +
 * ���㡱 + time[1] + "��" + time[2] + "��"); } try { Thread.sleep(5000); } catch
 * (InterruptedException e) { return; } } } }
 */