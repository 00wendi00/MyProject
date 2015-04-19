/**
 * 文件名：Myclass.java
 * 项目-包：测试 - 测试包
 * 作者：张文迪
 * 创建日期：2014-10-20
 */
package 测试包;

/**
 * @author 张文迪
 * 类名：Myclass
 * 类说明：第14 章：练习25，接口与类型信息 //final修饰的域不能改写~~
 */
class Myclass implements A
{
	public void f1()
	{
		System.out.println("调用了f1");
	}
	private void f2()
	{
		System.out.println("调用了f2");
	}
	private int i = 2;
	private final int k = 100; 
	private final String s = "~~~~~~~~~";
	public String toString()
	{
		return "k = "+k + ",s = "+s;
	}
}

