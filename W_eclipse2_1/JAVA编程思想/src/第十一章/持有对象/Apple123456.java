/**
 * 文件名：Apple123456.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-9-29
 */
package 第十一章.持有对象;

import java.util.ArrayList;

/**
 * @author 张文迪
 * 类名：Apple123456
 * 类说明：书例~
 */
class Apple
{
	private static long counter;
	private final long id = counter++;
	public long id()
	{
		return id;
	}
}
public class Apple123456
{
   public static void main(String args[])
   {
	   ArrayList<Apple> apples = new ArrayList<Apple>();
	   for(int i =0;i<6;i++)
		   apples.add(new Apple());
	   for(Apple a : apples)
		   System.out.println(a.id());
   }
}

