/**
 * �ļ�����StoryCharacters.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���·���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-21
 */
package ��ʮ���·���;

import java.util.*;
import net.mindview.util.Generator;

/**
 * @author ���ĵ�
 * ������StoryCharacters
 * ��˵������ϰ8   StoryCharactor ������~
 */
public class StoryGenerator implements Generator<StoryCharacters>,Iterator<StoryCharacters>
{
	private Class[] types = {GoodGuys.class,BadGuys.class};
	private static Random random = new Random(47);
	public StoryGenerator() {}
	private int size = 0;
	public StoryGenerator(int sz) {size = sz;}
	public StoryCharacters next()
	{
		try
		{
			return (StoryCharacters)
				types[random.nextInt(types.length)].newInstance();
		}
		catch ( Exception e)
		{
			throw new UnsupportedOperationException();
		}
	}
	class StoryIterator implements Iterator<StoryCharacters>
	{
		int count = size;
		public boolean hasNext()
		{
			return count>0;
		}
		public StoryCharacters next()
		{
			count--;
			return StoryGenerator.this.next();
		}
		public void remove()
		{
			throw new UnsupportedOperationException();
		}		
	};
	public Iterator<StoryCharacters> iterator()
	{
		return new StoryIterator();
	}
	public static void main(String args[])
	{
		StoryGenerator sto = new StoryGenerator();
		for(int i = 0;i<5;i++)
			System.out.println(sto.next());
	}
	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext()
	{
		// TODO Auto-generated method stub
		return false;
	}
	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove()
	{
		// TODO Auto-generated method stub
		
	}
}
class StoryCharacters
{
	private static long counter = 0;
	private final long id = counter ++;
	public String toString()
	{
		return getClass().getSimpleName()+" "+id;
	}
}
class GoodGuys extends StoryCharacters
{
	
}
class BadGuys extends StoryCharacters
{
	
}