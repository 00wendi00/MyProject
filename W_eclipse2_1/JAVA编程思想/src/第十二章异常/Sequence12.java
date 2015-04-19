/**
 * 文件名：Ex12.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：Ex12
 * 类说明：
 */
interface Selector 
{
	boolean end();
	Object current();
	void next();
}

public class Sequence12 {
	private Object[] items;
	private int next = 0;
	public Sequence12(int size) { items = new Object[size]; }
	public void add(Object x) throws ArrayIndexOutOfBoundsException 
	{
		// check for full array first:
		if(next == items.length)
			throw new ArrayIndexOutOfBoundsException();
		// if not full, fill:
		if(next < items.length)
			items[next++] = x;		
	}
	private class SequenceSelector implements Selector 
	{
		private int i = 0;
		public boolean end() { return i == items.length; }
		public Object current() { return items[i]; }
		public void next() { if(i < items.length) i++; } 
	}
	public Selector selector() 
	{
		return new SequenceSelector();
	}
	public static void main(String[] args) 
	{
		Sequence12 sequence = new Sequence12(10);//  ~!!!!
		for(int i = 0; i < 10; i++)
			sequence.add(Integer.toString(i));
		Selector selector = sequence.selector();
		while(!selector.end()) 
		{
			System.out.print(selector.current() + " ");
			selector.next();
		}
		System.out.println();
		// attempt to add object to full array produces 
		// ArrayIndexOutOfBoundsException:
		sequence.add(Integer.toString(10)+"");
	}
}
