/**
 * 文件名：Ex11.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-21
 */
package 第十五章泛型;

/**
 * @author 张文迪
 * 类名：Ex11
 * 类说明：练习 11~
 */
import net.mindview.util.*;
import java.util.*;

class A { public String toString() { return "A"; } }

class B { public String toString() { return "B"; } }

class C extends B 
{ 
	public String toString() { return "C"; }
}  

public class New11 
{
	public static void main(String[] args) 
	{
		A a = new A();
		B b = new B();
		C c = new C();
		List<C> lc = New.list();
		lc.add(new C());
		Map<A,List<? extends B>> mab = New.map();
		mab.put(a,lc);
		LinkedList<B> llb = New.lList();
		llb.add(new B());
		llb.add(new C());  // 参数类型 为基类型。。。
		Set<A> sa = New.set();
		sa.add(new A());
		Queue<B> qb = New.queue();
		qb.add(new B());
		System.out.println(lc);
		System.out.println(mab);
		System.out.println(llb);
		System.out.println(sa);
		System.out.println(qb);
	}
}