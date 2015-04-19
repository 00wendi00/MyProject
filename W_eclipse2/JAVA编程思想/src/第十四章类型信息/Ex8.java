/**
 * 文件名：Ex8.java
 * 项目-包：JAVA编程思想 - 第十四章类型信息
 * 作者：张文迪
 * 创建日期：2014-10-18
 */
package 第十四章类型信息;

/**
 * @author 张文迪
 * 类名：Ex8，9
 * 类说明： 递归  Hierarchy(Object o) + 练习9 Class.getDeclaredFields()的相关信息。
 */
class A {int i = 0;float  f;}

class B extends A {int a = 0;}

class C extends B {int b = 0;}

public class Ex8 
{
	public static void Hierarchy(Object o) 
	{
		if(o.getClass().getSuperclass() != null) 
		{		
			System.out.println(o.getClass() + " is a subclass of " + 
				o.getClass().getSuperclass()); 
			Object[] fields = o.getClass().getDeclaredFields();
			for(Object obj : fields)
				System.out.println(obj+" ");
			try {
				Hierarchy(o.getClass().getSuperclass().newInstance());
			} catch(InstantiationException e) {
				System.out.println("Unable to instantiate obj");
			} catch(IllegalAccessException e) {
				System.out.println("Unable to access");
			}
		} 
	}		
	public static void main(String[] args) 
	{
		Hierarchy(new C());
	}
}
