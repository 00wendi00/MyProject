/**
 * 文件名：Generators.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-21
 */
package 第十五章泛型;

import java.util.Collection;

import net.mindview.util.Generator;

/**
 * @author 张文迪
 * 类名：Generators
 * 类说明：
 */
public class Generators
{
	public static <T> Collection<T> 
			fill(Collection<T> coll,Generator<T> gen,int n)
	{
		for(int i =0;i<n;i++)
			coll.add(gen.next());
		return coll;
	}
}
