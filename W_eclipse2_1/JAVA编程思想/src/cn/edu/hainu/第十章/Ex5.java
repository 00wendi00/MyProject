/**
 * 文件名：Ex5.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第十章
 * 作者：张文迪
 * 创建日期：2014-9-25
 */
package cn.edu.hainu.第十章;


/**
 * @author 张文迪
 * 类名：Ex5
 * 类说明： 在类外部创建，此类的 内部类
 */
public class Ex5
{
	public static void main(String args[])
	{
		Outer outer = new Outer();
		//Inner inner = outer.ha111111();
		Outer.Inner inner = outer.new Inner();
		inner.ha1112();
		inner.toString();
		inner.toString();
	}
}
