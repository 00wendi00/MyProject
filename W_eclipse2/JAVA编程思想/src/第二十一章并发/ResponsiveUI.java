/**
 * 文件名：ResponsiveUI.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-5
 */
package 第二十一章并发;

/**
 * @author 张文迪
 * 类名：ResponsiveUI
 * 类说明：  创建有相应的用户界面~~  system.in.read()之后  才能继续执行~~~
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
		System.in.read();    // 终于知道这个 sysrem.in.read()的 用法了，就在控制台玩~~~
		System.out.println(d);
	}
}
