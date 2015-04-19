/**
 * 文件名：GenericMethods10.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-21
 */
package 第十五章泛型;

/**
 * @author 张文迪
 * 类名：GenericMethods10
 * 类说明：
 */
public class GenericMethods10
{
	public <MyClass10,B,C> void f(MyClass10 myClass10,B b,C c)
	{
		System.out.println(myClass10.getClass().getName()+" "+b.getClass().getName()+" "+c.getClass().getName());
	}
	public static void main(String args[])
	{
		GenericMethods9 ge = new GenericMethods9();
		ge.f(new MyClass10(), "!!!", 'q');
	}
}
class MyClass10
{
	MyClass10()
	{
		System.out.println("obc   nonononono no");
	}
}
