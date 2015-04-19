/**
 * 文件名：A123465798.java
 * 项目-包：JAVA编程思想 - 第七章复用类
 * 作者：张文迪
 * 创建日期：2014-9-8
 */
package 第七章复用类;

/**
 * @author 张文迪
 * 类名：A123465798
 * 类说明：练习5
 */
public class A123456789
{
    public static void main(String args[])
    {
    	new C123456789();
    	new B123456879('k');
    	new A123456789('0');
    }
    A123456789(char i)
    {
    	System.out.println("A123456789"+"  "+i);
    }
} 

class B123456879
{
   	B123456879(char i)
   	{
   		System.out.println("B123456789"+"  "+i);
   	}
}

class C123456789 extends A123456789
{
	B123456879 b123456879;
	
	C123456789()
	{
		super('f');		
	}	    
}