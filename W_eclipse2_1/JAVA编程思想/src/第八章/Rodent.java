/**
 * 文件名：Rodent.java
 * 项目-包：JAVA编程思想 - 第八章
 * 作者：张文迪
 * 创建日期：2014-9-10
 */
package 第八章;

/**
 * @author 张文迪
 * 类名：Rodent
 * 类说明：练习 9,12,14   创建~填充数组，然后再调用（方便扩展）。+  第九章 练习 1,2
 */
abstract public class Rodent
{
    protected static long m = 0;
   public static void main(String args[])
   {
	   Rodent[] allRodents = 
		{
			//new Rodent(),  //第九章 练习 1,2
			new Mouse(),
	        new Gerbil(),
	        new Hamster()
		};
	   System.out.println(m);
	   tuneAll(allRodents);
	   System.out.println(m+"  引用计数的  共享对象");
   }
   public void Howl()
   {
	   System.out.println("吱吱吱吱！！！");
   }
   public static void tuneAll(Rodent[] i)
   {
	   for(Rodent e:i)
		   tune(e);
   }
   public static void tune(Rodent k)
   {
	   m++;
	   k.Howl();  
	   System.out.println(m);// m = 6;
   }
   public Rodent()
   {
	   m++;
	   System.out.println("基类被初始化");
	   System.out.println(m);
   }
}
class Mouse extends Rodent
{
	public void Howl()
	{
		m++;
		System.out.println("哈哈哈哈！！！");
	}
	public Mouse()
	{
		m++;
		System.out.println("子类被初始化");
	}
}
class Gerbil extends Rodent
{
	public void Howl()
	{
		m++;
		System.out.println("嚯嚯嚯嚯！！！");
	}
}
class Hamster extends Rodent
{
	public void Howl()
	{
		m++;
		System.out.println("呵呵呵呵！！！");
	}
}

