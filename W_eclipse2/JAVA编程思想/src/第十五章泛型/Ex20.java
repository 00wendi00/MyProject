/**
 * 文件名：Ex20.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-21
 */
package 第十五章泛型;

/**
 * @author 张文迪
 * 类名：Ex20
 * 类说明：练习20~~~泛型类型参数的边界问题  extends 
 */
public class Ex20 
{
	public static void main(String args[])
	{
		MyClass201 myClass201 = new MyClass201();
		MyClass202 myClass202 = new MyClass202();
		//myClass202.haha111(myClass201);
		MyClass202.haha111(myClass201); // 应该静态访问~~
	}
}

interface MyHeihei20
{
	void heihei1();
	void heihei2();
}
class MyClass201 implements MyHeihei20
{
	public void heihei1()
	{
		System.out.println("111");
	}
	public void heihei2()
	{
		System.out.println("222");
	}	
	public void haha20()
	{
		System.out.println("haha20");
	}
}
class MyClass202
{
	public static <T extends MyHeihei20> void haha111(T t)
	{
		t.heihei1();
		t.heihei2();
		System.out.println("haha111");
	}
}
