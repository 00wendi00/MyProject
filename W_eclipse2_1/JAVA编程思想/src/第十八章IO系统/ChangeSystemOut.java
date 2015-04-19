/**
 * 文件名：ChangeSystemOut.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-2
 */
package 第十八章IO系统;

import java.io.PrintWriter;

/**
 * @author 张文迪
 * 类名：ChangeSystemOut
 * 类说明：
 */
public class ChangeSystemOut
{
	public static void main(String args[])
	{
		PrintWriter out = new PrintWriter(System.out,true);
		out.println("!!!!!!!!!!!!~~~~~");
	}
}
