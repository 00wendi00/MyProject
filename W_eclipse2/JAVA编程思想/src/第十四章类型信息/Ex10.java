/**
 * 文件名：Ex10.java
 * 项目-包：JAVA编程思想 - 第十四章类型信息
 * 作者：张文迪
 * 创建日期：2014-10-18
 */
package 第十四章类型信息;

/**
 * @author 张文迪
 * 类名：Ex10
 * 类说明：判断char数组是否为基本类型或对象：
 * 		1.调用isPrimitive()的时候返回值为false(不是基本数据类型);　
 *　		2.调用isArray()的时候返回值是true。（不是一个真正的对象）
 *		3.至于为什么要排除数组，标记，枚举，原始类型，有待考察
 */
public class Ex10
{
	public static void main(String args[])
	{
		char[] i = new char[10];
		System.out.println(i.getClass().getSuperclass());
		System.out.println(i instanceof Object);
		System.out.println(i.getClass().isArray());
		System.out.println();
		
		System.out.println(i.getClass().isPrimitive()); //是否为基本数据类型
		System.out.println(i.getClass().isEnum()); // 是否为枚举对象 
		System.out.println(i.getClass().isAnnotation());//是否为注释 
	}
}
