/**
 * �ļ�����LiftOff.java
 * ��Ŀ-����JAVA���˼�� - ����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-4
 */
package �ڶ�ʮһ�²���;

/**
 * @author ���ĵ�
 * ������LiftOff
 * ��˵����
 */
public class MainThread{
	public static void main(String args[])
	{
		LiftOff launch = new LiftOff();
		launch.run();
	}
}
class LiftOff implements Runnable
{
	protected int countDown = 10;
	private static  int taskCount = 0;
	private final int id = taskCount++;
	public LiftOff() {}
	public LiftOff(int countDown){
		this.countDown  = countDown;
	}
	public String  status(){
		return "#"+id+"("+(countDown>0 ? countDown : "liftoff!")+"),";
	}
	public void run()
	{
		while(countDown-->0){
			System.out.println(status());
			Thread.yield(); //�߳� �ǳ����е�ִ���̡߳�Java ���������Ӧ�ó��򲢷������ж��ִ���߳�
						   //Thread.yield()��ͣ��ǰ����ִ�е��̶߳��󣬲�ִ�������̡߳� 
		}
	}	
}
