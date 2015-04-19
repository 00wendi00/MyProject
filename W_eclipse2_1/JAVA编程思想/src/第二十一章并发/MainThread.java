/**
 * 文件名：LiftOff.java
 * 项目-包：JAVA编程思想 - 并发
 * 作者：张文迪
 * 创建日期：2014-11-4
 */
package 第二十一章并发;

/**
 * @author 张文迪
 * 类名：LiftOff
 * 类说明：
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
			Thread.yield(); //线程 是程序中的执行线程。Java 虚拟机允许应用程序并发地运行多个执行线程
						   //Thread.yield()暂停当前正在执行的线程对象，并执行其他线程。 
		}
	}	
}
