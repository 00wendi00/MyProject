/**
 * 文件名：Exx27.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-9
 */
package 第十一章.持有对象;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 张文迪
 * 类名：Exx27
 * 类说明：
 */
class Command1 
{
	String s;
	Command1(String s) { this.s = s; }
	void operation() { System.out.print(s); }
}

class Build 
{	
	Queue<Command1> makeQ() 
	{
		Queue<Command1> q = new LinkedList<Command1>();
		for(int i = 0; i < 10; i++)
			q.offer(new Command1(i + " "));
		return q;
	}
}
public class Exx27 
{
	public static void commandEater(Queue<Command1> qc) 
	{
		while(qc.peek() != null)
			qc.poll().operation();
	}
	public static void main(String[] args) 
	{
		Build b = new Build();
		commandEater(b.makeQ());	
	}
}
