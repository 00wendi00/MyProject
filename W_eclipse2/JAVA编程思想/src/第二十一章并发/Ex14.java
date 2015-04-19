/**
 * �ļ�����Ex14.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-5
 */
package �ڶ�ʮһ�²���;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


/**
 * @author ���ĵ�
 * ������Ex14
 * ��˵����  args[0] = 55555555 �����ˣ� �ܴ����~~
 */
public class Ex14 
{
	public static void main(String[] args) throws Exception 
	{
		if(args.length < 1) 
		{
			System.err.println(
			"Usage: java E14_ManyTimers <num of timers>");
		}
		int numOfTimers = Integer.parseInt(args[0]);
		for(int i = 0; i < numOfTimers; i++) 
		{
			new Timer().schedule(new TimerTask()    //����һ���¼�ʱ������ص��̲߳� ��Ϊ�ػ��������С� 
			{         //������ָ���ӳٺ�ִ��ָ��������  ����Ϊ  ���ŵ����� ��ʱ�䡣
				public void run() {
					System.out.println(System.currentTimeMillis());
				}
			}, numOfTimers - i);
		}
		// Wait for timers to expire
		TimeUnit.MILLISECONDS.sleep(2 * numOfTimers);
		//TimeUnit ��ʾ������Ԫ���ȵ�ʱ��Σ����ṩ����Щ��Ԫ�н��п絥Ԫת����ִ�м�ʱ���ӳٲ�����ʵ�ù��߷���
		System.exit(0);
	}
}
