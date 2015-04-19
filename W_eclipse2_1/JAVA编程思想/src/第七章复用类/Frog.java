/**
 * 文件名：Amphibian.java
 * 项目-包：JAVA编程思想 - 第七章复用类
 * 作者：张文迪
 * 创建日期：2014-9-9
 */
package 第七章复用类;

/**
 * @author 张文迪
 * 类名：Amphibian
 * 类说明：练习 16,17.   Upcasting
 */
public class Frog extends Amphibian
{
	
     public static void main(String args[])
     {
    	 Frog frog = new Frog();
    	 //Frog amphibian = new Frog();
    	 Amphibian.caoanimabi(frog);   	
     }
     static void caoanimabi(Frog a)
     {
    	 a.HaoDe0();
     }
     protected void HaoDe0()
 	{
 		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
 	}
}
class Amphibian 
{
	static void caoanimabi(Frog a)
	{
		System.out.println(" 好的 吧 ！");
		a.HaoDe0();
		
	}
	Amphibian()
	{
		System.out.println("额");
	}
	protected void HaoDe0()
	{
		System.out.println("~~~~~~");
	}
}