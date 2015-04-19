/**
 * 文件名：Sequence4.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第十章
 * 作者：张文迪
 * 创建日期：2014-9-27
 */
package cn.edu.hainu.第十章;

/**
 * @author 张文迪
 * 类名：Sequence4
 * 类说明：  
 */

public class Sequence4 
{
	private Object[] items;
	private int next = 0;
	// to test SequenceSelector sequence4() in main():
	public void test() { System.out.println("Sequence4.test()"); }
	public Sequence4(int size) { items = new Object[size]; }
	public void add(Object x) {
		if(next < items.length)
			items[next++] = x;
	}
	private class SequenceSelector implements Selector 
	{
		private int i = 0;
		public boolean end() { return i == items.length; }
		public Object current() { return items[i]; }
		public void next() { if(i < items.length) i++; } 
		// method to produce outer class reference:
		public Sequence4 sequence4() { return Sequence4.this; }
	}
	public Selector selector() 
	{
		return new SequenceSelector();
	}
	public static void main(String[] args) 
	{
		Sequence4 sequence = new Sequence4(10);
		for(int i = 0; i < 10; i++)
			sequence.add(Integer.toString(i));
		Selector selector = sequence.selector();
		while(!selector.end()) 
		{
			System.out.print(selector.current() + " ");
			selector.next();
		}
		// cast and test:
		((SequenceSelector)selector).sequence4().test();	
	}
}