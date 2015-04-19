/**
 * 文件名：Conversion.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-14
 */
package 第十三章字符串;

import java.util.Formatter;

/**
 * @author 张文迪
 * 类名：Conversion
 * 类说明：练习5 ~~~类型转换~
 */
public class Conversion
{
	public static void main(String args[])
	{
		Formatter f = new Formatter(System.out);
		int v = 121;
		System.out.println("v = 121");
		f.format("d: %d\n", v);
		f.format("c: %c\n", v);
		f.format("b: %b\n", v);
		f.format("s: %s\n", v);
		f.format("x: %x\n", v);
		f.format("h: %h\n", v);
		
	}
}
