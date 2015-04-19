/**
 * 文件名：Holder1.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-20
 */
package 第十五章泛型;

/**
 * @author 张文迪
 * 类名：Holder1
 * 类说明：练习1  持有基类类型   就可以  持有子类类型；
 */
public class Holder1<T>
{
	private T a ;
	public Holder1(T a) {this.a = a;}
	public void set(T a) {this.a = a;}
	public T get() {return a;}
	public static void main(String args[])
	{
		Holder1<A1> h1 = new Holder1<A1>(new A1());
		A1 a1 = h1.get(); 
		a1.a1111();
		
		Holder1<B1> h2 = new Holder1<B1>(new B1());
		B1 b1 = h2.get();
		b1.a1111();
		b1.b1111();
	}
}
class A1
{
	void a1111()
	{
		System.out.println("111");
	}
}
class B1 extends A1
{
	void b1111()
	{
		System.out.println("222");
	}
	
}
