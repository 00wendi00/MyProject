/**
 * 文件名：GenericMethods.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-21
 */
package 第十五章泛型;

/**
 * @author 张文迪
 * 类名：GenericMethods
 * 类说明：
 */
public class GenericMethods9
{
	public <A,B,C> void f(A a,B b,C c)
	{
		System.out.println(a.getClass().getName()+" "+b.getClass().getName()+" "+c.getClass().getName());
	}
	public static void main(String args[])
	{
		GenericMethods9 ge = new GenericMethods9();
		ge.f(1, "!!!", 'q');
	}
}
