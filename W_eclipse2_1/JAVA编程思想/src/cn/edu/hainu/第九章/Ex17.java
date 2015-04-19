/**
 * 文件名：Ex17.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第九章
 * 作者：张文迪
 * 创建日期：2014-9-24
 */
package cn.edu.hainu.第九章;

/**
 * @author 张文迪
 * 类名：Ex17
 * 类说明：
 */
interface Days {
	int SUNDAY = 1, MONDAY = 2, TUESDAY = 3, WEDNESDAY = 4, 
		THURSDAY = 5, FRIDAY = 6, SATURDAY = 7; 
}

class Week implements Days 
{
	private static int count = 0;
	private int id = count++;
	public Week() { System.out.println("Week() " + id); }
}

public class Ex17 
{
	public static void main(String[] args) 
	{
		// Without any objects, static fields exist:
		System.out.println("SUNDAY = " + Days.SUNDAY);
		System.out.println("MONDAY = " + Days.MONDAY);
		Week w0 = new Week();
		Week w1 = new Week();
		// Error: cannot assign a value to final variable SUNDAY:
		// w.SUNDAY = 2;
		// Error: cannot assign a value to final variable MONDAY: 
		 //w1.MONDAY = w0.MONDAY;//days.MONDAY  静态方式
	}
}
