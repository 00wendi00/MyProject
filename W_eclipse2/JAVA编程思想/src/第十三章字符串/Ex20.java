/**
 * 文件名：Ex20.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-16
 */
package 第十三章字符串;

import java.util.Scanner;

/**
 * @author 张文迪
 * 类名：Ex20
 * 类说明：
 */

/*练习20~~~~~~~~~~~~正解
 * public class Scanner20 
 * {
	int i;
	long L;
	float f;
	double d;
	String s;
	Scanner20(String s) 
	{
		Scanner sc = new Scanner(s);
		i = sc.nextInt();
		L = sc.nextLong();
		f = sc.nextFloat();
		d = sc.nextDouble();
		this.s = sc.next(); 		
	}
	public String toString() 
	{
		return i + " " + L + " " + f + " " + d + " " + s;
	}
	public static void main(String[] args) 
	{
		Scanner20 s20 = new Scanner20("17 56789 2.7 3.61412 hello");
		System.out.println(s20);
	}
}
 */



public class Ex20
{
	int i = 9;
	long l = 8;
	float f = 7;
	double d = 6.6;
	String s1 = "额 ";
	Ex20(String s)
	{
		Scanner scanner = new Scanner(s1+i+l+f+d+s);
		System.out.println(scanner.nextLine());
	}
	public String toString()
	{
		return s1;
	}
	public static void main(String args[])
	{
		Ex20 ex20 = new Ex20("哈哈 ~~~~~~~~");
	}
}
