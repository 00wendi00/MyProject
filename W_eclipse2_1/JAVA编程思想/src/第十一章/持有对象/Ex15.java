/**
 * 文件名：Ex15.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-8
 */
package 第十一章.持有对象;

import java.util.Stack;

/**
 * @author 张文迪
 * 类名：Ex15
 * 类说明： 应该用 Character~~~   ++++  split 的用法  .   
 */
public class Ex15
{
	public static void main(String args[])
	{
		Stack<String> st = new Stack<String>();
		for(String s : "U n c".split(" "))
			st.push(s);
		while(!st.empty())
			System.out.println(st.pop()+" ");
	}
}
