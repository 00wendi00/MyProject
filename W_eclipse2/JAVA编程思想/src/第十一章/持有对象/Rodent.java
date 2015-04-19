/**
 * 文件名：Rodent.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-1
 */
package 第十一章.持有对象;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 张文迪
 * 类名：Rodent
 * 类说明： 练习10.
 */
abstract public class Rodent
{
   protected static long m = 0;
   public static void main(String args[])
   {
	   ArrayList<Rodent> rodent000 = new ArrayList<Rodent>();
	   rodent000.add(new Mouse());
	   rodent000.add(new Gerbil1());
	   rodent000.add(new Hamster());
	 
	   System.out.println(m);
	   
	   System.out.println(m+"  引用计数的  共享对象");
	   
	   Iterator<Rodent> it = rodent000.iterator();
	   while(it.hasNext())
	   {
		   Rodent r = it.next();
		   System.out.println(r);
		   r.Howl();
		   System.out.println();
	   }
   }
   public void Howl()
   {
	   System.out.println("吱吱吱吱！！！");
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
class Gerbil1 extends Rodent
{
	public Gerbil1()
	{
		
	}

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
