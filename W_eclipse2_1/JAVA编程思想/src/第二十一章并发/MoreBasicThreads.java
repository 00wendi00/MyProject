/**
 * �ļ�����MoreBasicThreads.java
 * ��Ŀ-����JAVA���˼�� - ����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-4
 */
package �ڶ�ʮһ�²���;

/**
 * @author ���ĵ�
 * ������MoreBasicThreads
 * ��˵����
 */
public class MoreBasicThreads
{
	public static void main(String args[])
	{
		for(int i = 0;i<5;i++)
			new Thread(new LiftOff()).start();
		System.out.println("Start~~~~~~~~~~");
	}
}
