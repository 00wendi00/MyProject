/**
 * 文件名：Holder3.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-20
 */
package 第十五章泛型;

/**
 * @author 张文迪
 * 类名：Holder3
 * 类说明：练习1~~~
 */
import typeinfo.pets.*;

public class Holder3<T> {
	private T a;
	public Holder3(T a) { this.a = a; }
	public void set(T a) { this.a = a; }
	public T get() { return a; }
	public static void main(String[] args) {
		Holder3<Pet> h3 = 
			new Holder3<Pet>(new Pet());
		Pet a = h3.get(); // No cast needed
		System.out.println(h3.get());
		// can also hold a subclass of Pet:
		h3.set(new Dog());
		System.out.println(h3.get());
		// can also hold a sububclass of Pet:

		
	}
}