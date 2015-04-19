/**
 * 文件名：MyTest.java
 * 项目-包：测试 - 打地鼠代码
 * 作者：张文迪
 * 创建日期：2014-10-20
 */
package 打地鼠代码;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import 测试包.A;
import 测试包.HiddenMyclass;

/**
 * @author 张文迪
 * 类名：MyTest
 * 类说明：第14 章：练习25，接口与类型信息 //final修饰的域不能改写~~
 */
public class MyTest
{
	public static void main(String args[]) throws Exception
	{
		A a = HiddenMyclass.makeA();
		a.f1();
		System.out.println(a.getClass().getName());
	
		Method g = a.getClass().getDeclaredMethod("f2");
		g.setAccessible(true);
		g.invoke(a);
		System.out.println();
		
		Field f = a.getClass().getDeclaredField("i");
		f.setAccessible(true);
		f.getInt(a);
		f.setInt(a, 50);
		System.out.println("i = "+f.getInt(a));
				
		f = a.getClass().getDeclaredField("k");
		f.setAccessible(true);
		f.getInt(a);
		f.setInt(a, 555);
		System.out.println("k = "+f.getInt(a));
		
		f = a.getClass().getDeclaredField("s");		
		f.setAccessible(true);
		System.out.println("s = "+f.get(a));
		f.get(a);
		f.set(a ,"!!!!!!!!!!!");
		System.out.println("s = "+f.get(a));
		System.out.println(a);//final修饰的域不能改写~~
	}
}
