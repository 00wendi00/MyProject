/**
 * 文件名：LinkedStack.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-20
 */
package 第十五章泛型;



/**
 * @author 张文迪
 * 类名：LinkedStack
 * 类说明：练习5~~内部类可以访问外部类的类型参数~
 */
public class LinkedStack5<T> 
{
	// make Node a nonstatic class to access nonstatic T:
	private class Node 
	{
		T item;
		Node next;
		Node() { item = null; next = null; }
		Node(T item, Node next) 
		{
			this.item = item;
			this.next = next;
		}
		boolean end() { return item == null && next == null; }
	}
	private Node top = new Node(); // End sentinel
	public void push(T item) 
	{
		top = new Node(item, top);
	}
	public T pop() 
	{
		T result = top.item;
		if(!top.end())
			top = top.next;
		return result;
	}
	public static void main(String[] args) 
	{
		LinkedStack5<String> lss = new LinkedStack5<String>();
		for(String s: "Phasers on stun!".split(" ")) 
			lss.push(s);
		String s;
		while((s = lss.pop()) != null)
			System.out.println(s);
	}
}
