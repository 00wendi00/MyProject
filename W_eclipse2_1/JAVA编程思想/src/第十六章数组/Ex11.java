/**
 * 文件名：Ex11.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-26
 */
package 第十六章数组;

/**
 * @author 张文迪
 * 类名：Ex11
 * 类说明： 自动包装机制不能用于数组
 */
public class Ex11 
{
	public static void main(String[] args) 
	{
		int[] ia = new int[2];
		ia[0] = new Integer(1); // will be autoboxed to int
		ia[0] = new Integer(2); // autoboxing does work here
		// an array of primitive int:
		System.out.println(ia.getClass().getName());
		Integer[] Ia = new Integer[2];
		Ia[0] = 1; // will be autoboxed to Integer
		Ia[1] = (int)2; // autoboxing works here
		// an array of Integer:
		System.out.println(Ia.getClass().getName());
		System.out.println(Ia[0] instanceof Integer);
		for(int i = 0; i < Ia.length; i++)
			System.out.println(Ia[i].getClass().getName());
		// Integer[] cannot be assigned to int[]:
		//ia = Ia; // error: incompatible types
		Ia[0] = (int)ia[0]; // more autoboxing
		System.out.println(Ia[0].getClass().getName());		
	}
}
