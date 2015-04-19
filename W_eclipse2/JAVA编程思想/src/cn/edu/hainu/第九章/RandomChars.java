/**
 * 文件名：RandomChars.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第九章
 * 作者：张文迪
 * 创建日期：2014-9-24
 */
package cn.edu.hainu.第九章;

import java.util.Random;

/**
 * @author 张文迪
 * 类名：RandomChars
 * 类说明： 练习 16~~~
 */
public class RandomChars 
{
	private static Random rand = new Random();
	public char next() 
	{
		return (char)rand.nextInt(128);		
	}
	public static void main(String[] args) 
	{			
		RandomChars rc = new RandomChars();
		for(int i = 0; i < 10; i++)
		System.out.print(rc.next() + " ");
	}
}
