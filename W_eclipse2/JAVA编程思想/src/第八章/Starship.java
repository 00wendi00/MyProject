/**
 * 文件名：Starship.java
 * 项目-包：JAVA编程思想 - 第八章
 * 作者：张文迪
 * 创建日期：2014-9-10
 */
package 第八章;

/**
 * @author 张文迪
 * 类名：Starship
 * 类说明： 练习16： 组合更加灵活
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