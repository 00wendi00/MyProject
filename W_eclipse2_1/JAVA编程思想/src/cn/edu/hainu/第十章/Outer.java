/**
 * 文件名：Outer.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第九章
 * 作者：张文迪
 * 创建日期：2014-9-25
 */
package cn.edu.hainu.第十章;
/**
 * @author 张文迪
 * 类名：Outer
 * 类说明：练习 1 , 3
 */
public class Outer
{
	private  String s = "!!!!!!";	
    class Inner
    {
    	public void ha1112()
    	{
    		System.out.println("~~~~~~~~");
    	}
    	public String toString()
    	{
    		System.out.println(s);
    		return s;
    	}
    }
    public Inner ha111111()
    {
    	return new Inner();
    }
    public static void main(String args[])
    {
    	Outer outer = new Outer();
    	Inner inner = outer.ha111111();
    	inner.ha1112();
    	inner.toString();
    }
}
