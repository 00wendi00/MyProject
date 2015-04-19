/**
 * 文件名：Ex10.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-26
 */
package 第十六章数组;
import java.util.*;

/**
 * @author 张文迪
 * 类名：Ex10
 * 类说明： 练习10   使用2层容器   List<List<A>> llb = new ArrayList<List<A>>();
 */
public class ArrayOfGenerics10 {
	@SuppressWarnings("unchecked") //不必要的~~  根除了编译期的警告信息!
	public static void main(String[] args) {
		List<List<String>> lls = new ArrayList<List<String>>();
		List<List> l = new ArrayList<List>();	
		// lls = (List<List<String>>)l; // error: inconvertible types
		lls.add(new ArrayList<String>());
		List<Object> lo = new ArrayList<Object>();
		// lo = lls; // error: incompatible types
		// Compile-time warning eliminated:
		List<List<A>> llb = new ArrayList<List<A>>();
		for(int i = 0; i < 3; i++) 
		{
			llb.add(new ArrayList<A>());
			for(int j = 0; j < 2; j++)
				llb.get(i).add(new A());
		}
		System.out.println(llb);	
	}
}
