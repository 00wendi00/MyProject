/**
 * 文件名：ExplicitStatic.java
 * 项目-包：JAVA编程思想 - 第五章初始化与清理
 * 作者：张文迪
 * 创建日期：2014-9-6
 */
package 第五章初始化与清理;

/**
 * @author 张文迪
 * 类名：ExplicitStatic
 * 类说明：练习13.  静态初始化是否执行。
 */
class Cup
{
	Cup(int marker)
	{
	    System.out.println("Cup("+marker+")");
	}
	void f(int marker)
	{
		System.out.println("f("+marker+")");
	}
}

class Cups
{
     static Cup cup1;
     static Cup cup2;
     static 
     {
    	 cup1 = new Cup(1);
    	 cup2 = new Cup(2);
     }
     Cups()
     {
    	 System.out.println("Cups()");
     }
}



public class ExplicitStatic
{
     public static void main(String args[])
     {
    	 System.out.println("Inside main()");;
    	 Cups.cup1.f(99);
     }
     static Cups cups1 = new Cups();//先静态初始化
     //static Cups cups1 = new Cups();//且 只执行一次
}
