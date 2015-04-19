/**
 * 文件名：Ex27.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-9
 */
package 第十一章.持有对象;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author 张文迪
 * 类名：Ex27
 * 类说明：
 */
public class Ex27
{
    public static void main(String args[])
    {
    	Ex27 ex27 = new Ex27();
    	ex27.haha2((new Class2()).haha1());
    }
    void haha2(Queue<Command> queue)
    {
    	while(queue.peek() != null)
    	{
    		new Command().operation();
    		System.out.println(queue.remove()+"");
    	}
    	System.out.println();
    }
}
class Command
{
	String s = "哈哈";

	void operation()
	{
		System.out.println(s);
	}
}
class Class2
{
	int k = 5;
	 Queue<Command> haha1()
	{
		Queue<Command> queue = new LinkedList<Command>();
		for(int i = 0;i<k;i++)
			queue.offer(new Command());
		return queue;
	}
}
