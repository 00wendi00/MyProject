/**
 * �ļ�����BasicThreads.java
 * ��Ŀ-����JAVA���˼�� - ����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-4
 */
package �ڶ�ʮһ�²���;

/**
 * @author ���ĵ�
 * ������BasicThreads
 * ��˵����
 */
public class BasicThreads
{
	public static void main(String args[])
	{
		Thread t = new Thread(new LiftOff());
		t.start();
		System.out.println("Start~~~~~~~~~");
	}
}
