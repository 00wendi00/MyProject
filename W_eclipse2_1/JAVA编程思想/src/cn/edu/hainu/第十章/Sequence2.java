/**
 * 文件名：Sequence2.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第十章
 * 作者：张文迪
 * 创建日期：2014-9-27
 */
package cn.edu.hainu.第十章;

/**
 * @author 张文迪
 * 类名：Sequence2
 * 类说明：练习 22 :  在单个外围类中，可以让多个内部类实现同一个接口~~~   //Selector
 */

class Word 
{
	private String word;
	public Word(String s) 
	{ 
		word = s; 
	}
	public String toString() 
	{
		return word; 
	}
} 

interface Selector 
{
	boolean end();
	Object current();
	void next();
}

public class Sequence2 
{
	private Object[] items;
	private int next = 0;
	public Sequence2(int size) 
	{ 
		items = new Object[size];
    }
	public void add(Object x) 
	{
		if(next < items.length)
			items[next++] = x;
	}
	
	private class SequenceSelector implements Selector 
	{
		private int i = 0;
		public boolean end() 
		{
			return i == items.length; 
		}
		public Object current() 
		{
			return items[i]; 
		}
		public void next() 
		{
			if(i < items.length) i++; 
		} 
	}
	private class ReverseSelector implements Selector
	{
		private int i = items.length;
		public boolean end()
		{
			return i == 0;
		}
		public Object current()
		{
			return items[i-1];
		}
		public void next()
		{
			if(i > 0) 
				i--;
		}		
	}
	public Selector selector1() 
	{
		return new SequenceSelector();
	}
	public Selector selector2()
	{
		return new ReverseSelector();
	}
	public static void main(String[] args) 
	{
		Sequence2 sequence = new Sequence2(10);
		for(int i = 0; i < 10; i++)
			sequence.add(new Word(Integer.toString(i)));
		Selector selector = sequence.selector1();
		while(!selector.end())
		{
			System.out.print(selector.current() + " ");
			selector.next();
		}
		
		
		
		Word w1 = new Word("Peace");
		Word w2 = new Word("Love");
		Word w3 = new Word("Easter");
		Sequence2 message = new Sequence2(3);
		message.add(w1);
		message.add(w2);
		message.add(w3);
		Selector sel1 = message.selector1();
		while(!sel1.end()) 
		{
			System.out.print(sel1.current() + " ");
			sel1.next();
		}	
		
		
		
		System.out.println();
		message.add(w1);
		message.add(w2);
		message.add(w3);
		Selector sel2 = message.selector2();
		while(!sel2.end())
		{
			System.out.print(sel2.current() + " ");
			sel2.next();
			
		}
			
		
	}
}