/**
 * 文件名：BasicGeneratorDemo.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-21
 */
package 第十五章泛型;

import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;

/**
 * @author 张文迪
 * 类名：BasicGeneratorDemo
 * 类说明：联系14~~~~
 */
public class BasicGeneratorDemo14
{
	public static void main(String args[])
	{
		Generator<CountedObject> gen = new BasicGenerator<CountedObject>(CountedObject.class);
		for(int i = 0; i < 4; i++)
			System.out.println(gen.next());
	}
}
class CountedObject
{
	private static long counter = 0;
	private final long id = counter++;
	public long id() {return id;}
	public String toString() {return "Countedobject "+id;} 
}
