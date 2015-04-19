/**
 * 文件名：HorrorShow.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第九章
 * 作者：张文迪
 * 创建日期：2014-9-24
 */
package cn.edu.hainu.第九章;

/**
 * @author 张文迪
 * 类名：HorrorShow
 * 类说明： 练习14 , 15
 */
public class HorrorShow
{
	static void a(Color q){q.color1();q.color2();}
	static void b(Shape q){q.shape1();q.shape2();}
	static void c(Weigth q){q.weigth1();q.weigth2();}
	static void d(Attribute q){q.attribute();}
    public static void main(String args[])
    {
    	Son1 s = new Son1();
    	a(s);
    	b(s);
    	c(s);
    	d(s);
    }
}
interface Color
{
	void color1();
	void color2();
}
interface Shape
{
    void shape1();
    void shape2();
}
interface Weigth
{
	void weigth1();
	void weigth2();
}
interface Attribute extends Color,Shape,Weigth
{
	void attribute();
}
abstract class Father1
{
	Father1()
	{
		System.out.println("~~~~~~~~~~");
	}
}
class Son1 extends Father1 implements Attribute
{
	public void color1()
	{
		System.out.println("c1");
	}
	public void color2()
	{
		System.out.println("c2");
	}
	public void shape1()
	{
	    System.out.println("s1");
	}
	public void shape2()
	{
		System.out.println("s2");
	}
	public void weigth1()
	{
		System.out.println("w1");
	}
	public void weigth2()
	{
		System.out.println("w2");
	}
	public void attribute()
	{
		System.out.println("a1");
	}	
}
