/**
 * 文件名：EnumClass.java
 * 项目-包：JAVA编程思想 - 第十九章枚举类型
 * 作者：张文迪
 * 创建日期：2014-11-3
 */
package 第十九章枚举类型;

import net.mindview.util.Print.*;

/**
 * @author 张文迪
 * 类名：EnumClass
 * 类说明：
 */
enum Shrubbery { GROUND,CRAWLING,HANGING }
public class EnumClass
{
	public static void main(String args[])
	{
		System.out.println(" !!!!!!!!");
		for(Shrubbery s : Shrubbery.values() )
		{
		     System.out.println(s+ " " + s.ordinal());
		     //返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）。 大多数程序员不会使用此方法
		     System.out.print(s.compareTo(Shrubbery.HANGING));
		     System.out.print(s== Shrubbery.CRAWLING);
		     System.out.println(s.getDeclaringClass());
		     System.out.println(s.name());
		     System.out.println("-------------");
		}
		for(String s: "HANGING CRAWLING GROUND".split(" "))
		{
			Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
			System.out.println(shrub);
		}
	}
}
