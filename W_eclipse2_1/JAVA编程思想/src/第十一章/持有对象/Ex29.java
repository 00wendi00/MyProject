/**
 * 文件名：Ex29.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-9
 */
package 第十一章.持有对象;

import java.util.PriorityQueue;

/**
 * @author 张文迪
 * 类名：Ex29
 * 类说明：Exception ~~~~
 */
class Simple extends Object {}

public class Ex29 
{
	public static void main(String[] args)
	{		
		PriorityQueue<Simple> s = new PriorityQueue<Simple>();
		// OK to add one Simple:
		s.offer(new Simple());
		// but no more allowed; get runtime exception: 
		// Simple cannot be cast to Comparable:
		s.offer(new Simple());
	}
}