/**
 * 文件名：GenericSequence.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-20
 */
package 第十五章泛型;

/**
 * @author 张文迪
 * 类名：GenericSequence
 * 类说明：
 */
import java.util.*;

interface Selector 
{
	boolean end();
	Object current();
	void next();
}

public class GenericSequence<E> 
{	
	private List<E> list = new ArrayList<E>();
	private int next = 0;
	public GenericSequence(List<E> list) { this.list = list; }
	public void add(E e) { list.add(e); }
	private class SequenceSelector implements Selector 
	{
		private int i = 0;
		public boolean end() { return i == list.size(); }
		public Object current() { return list.get(i); }
		public void next() { if(i < list.size()) i++; } 
	}
	public Selector selector() 
	{
		return new SequenceSelector();
	}
	public static void main(String[] args) 
	{
		List<String> ls = new ArrayList<String>();
		GenericSequence<String> gs = new GenericSequence<String>(ls);
		for(int i = 0; i < 10; i++)
			gs.add(Integer.toString(i));
		Selector selector = gs.selector();
		while(!selector.end()) 
		{
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
}
