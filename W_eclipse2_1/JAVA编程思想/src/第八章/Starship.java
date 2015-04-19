/**
 * �ļ�����Starship.java
 * ��Ŀ-����JAVA���˼�� - �ڰ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-10
 */
package �ڰ���;

/**
 * @author ���ĵ�
 * ������Starship
 * ��˵���� ��ϰ16�� ��ϸ������
 */
public class Starship
{
	public static void main(String args[])
	{
		AlertStatus alertStatus = new AlertStatus();
		alertStatus.chang1();
		alertStatus.chang2();
		alertStatus.chang1();
	}
}
class AlertStatus
{
	 private Actor actor = new HappyActor();
	 public void chang1()
	 {
		 actor.act();
	 }
	 public void chang2()
	 {
		 actor = new SadActor();
	 }
}
class Actor
{
    public void act()
    {
    	
    }
}
class HappyActor extends Actor
{
    public void act()
    {
    	System.out.println("HappyActor");
    }
}
class SadActor extends Actor
{
    public void act()
    {
    	System.out.println("SadActor");
    }
}