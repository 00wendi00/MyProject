/**
 * �ļ�����Ex27.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-9
 */
package ��ʮһ��.���ж���;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author ���ĵ�
 * ������Ex27
 * ��˵����
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
	String s = "����";

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
