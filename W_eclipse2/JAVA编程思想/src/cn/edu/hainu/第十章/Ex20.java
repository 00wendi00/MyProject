/**
 * 文件名：Ex20.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第十章
 * 作者：张文迪
 * 创建日期：2014-9-27
 */
package cn.edu.hainu.第十章;

/**
 * @author 张文迪
 * 类名：Ex20
 * 类说明： 练习 20 ,21  ：  接口内部的类。
 */
public class Ex20 implements OneClass
{
   public static void main(String args[])
   {
	   OneClass class1 = new Ex20();
	   class1.haode();
	   
	   OneClass class2 = new Test();
	   class2.haode();
	   ((Test) class2).one();   //必须向下转型 ，才认识。
	   
	   Test.haode00(class1); 
	   Test.haode00(class2);
	   OneClass.Test.haode00(class1);
   }
   public void haode()
   {
	System.out.println("好的 123");
   }
   public String haode111()
   {
	   return "!!!!!!!!!!!!!";
   }
}
interface OneClass
{
    void haode();
    String haode111();
    class Test implements OneClass
    {
		public void haode()
		{
			System.out.println("好的~！");
		}  
		void one()
		{
			System.out.println("One!!!");
		}
		public static  void haode00(OneClass oneClass)
		{
			System.out.println(oneClass.haode111());
		}
		
		
		public static void main(String args[])
		{
			new Test().haode();
		}
		
		
		public String haode111()
		{
			return "~~~~~~~~~~";
		}
    }
}