/**
 * 文件名：AdaptedRandomChars16.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第九章
 * 作者：张文迪
 * 创建日期：2014-9-24
 */
package cn.edu.hainu.第九章;

import java.nio.CharBuffer;
import java.util.Scanner;
/**
 * @author 张文迪
 * 类名：AdaptedRandomChars16
 * 类说明： 练习 16~~~
 */
public class AdaptedRandomChars16 extends RandomChars implements Readable 
{
	private int count;
	
	public AdaptedRandomChars16(int count) 
	{
		this.count = count;
	}			
	public int read(CharBuffer cb) 
	{
		if(count-- == 0) 
			return -1;
		String result = Character.toString(next()) + " ";
		cb.append(result);
		return result.length();
	}
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(new AdaptedRandomChars16(10));
		while(s.hasNext())
			System.out.print(s.next() + " ");
		System.out.println();
	}
}