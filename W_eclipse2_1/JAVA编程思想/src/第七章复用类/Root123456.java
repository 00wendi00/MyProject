/**
 * 文件名：Root123456.java
 * 项目-包：JAVA编程思想 - 第七章复用类
 * 作者：张文迪
 * 创建日期：2014-9-8
 */
package 第七章复用类;


/**
 * @author 张文迪
 * 类名：Root123456
 * 类说明：练习9,10,12
 */
public class Root123456
{
     public static void main(String args[])
     {
    	 Root123456 root123456 = new Root123456();
    	 Stem123456 stem123456 = new Stem123456();
    	 Component1 component1 = new Component1();
    	 Component2 component2 = new Component2();
    	 Component3 component3 = new Component3();  
    	 
    	 //root123456.Root12();
    	 
    	 stem123456.Root12();  	 
    	 stem123456.Stem1();
    	 
    	 System.out.println();
    	 
    	 
    	 stem123456.dispose();
    	
    	 
    	 
    	 
    	 
    	 try{}
    	 finally
    	 {
    		
    	 }
    	   		     	   	 
     }

	public void Root12()
	{
		System.out.println("0");
	}
	void dispose()
	{
		System.out.println("清理了！");
	}
}
class Stem123456 extends Root123456
{
	public void Stem1()
	{
		super.Root12();
		System.out.println("00000000");
	}	
	void dispose()
	{
		
		System.out.println("清理了！！！！！！！！！！！！！");
		super.dispose();
	}
}
class Component1
{
   	public void Comp1()
   	{
   		System.out.println("111111111");
   	}
}
class Component2
{
   	public void Comp2()
   	{
   		System.out.println("222222222");
   	}
}
class Component3
{
   	public void Comp3()
   	{
   		System.out.println("333333333");
   	}
}