/**
 * �ļ�����ResponsiveUI.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-5
 */
package �ڶ�ʮһ�²���;

/**
 * @author ���ĵ�
 * ������ResponsiveUI
 * ��˵����  ��������Ӧ���û�����~~  system.in.read()֮��  ���ܼ���ִ��~~~
 */
public class ResponsiveUI extends Thread
{
	private static volatile double d = 1;
	public ResponsiveUI(){
		setDaemon(true);
		start();
	}
	public void run(){
		while(true){
			d = d+(Math.PI+Math.E)/d;
		}
	}
	public static void main(String args[])throws Exception
	{
		new ResponsiveUI();
		System.in.read();    // ����֪����� sysrem.in.read()�� �÷��ˣ����ڿ���̨��~~~
		System.out.println(d);
	}
}
