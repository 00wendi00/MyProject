/**
 * 文件名：AssociativeArray.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-29
 */
package 第十七章深入研究容器;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;



/**
 * @author 张文迪
 * 类名：AssociativeArray
 * 类说明：
 */
public class AssociativeArray12<K,V>
{
	private Object[][] pairs;
	private int index;
	public AssociativeArray12(int length)
	{
		pairs = new Object[length][2];
	}
	public void put(K key,V value)
	{
		if(index>=pairs.length)
			throw new ArrayIndexOutOfBoundsException();
		pairs[index++] = new Object[] {key,value};
	}
	@SuppressWarnings("unchecked")
	public V get(K keyK)
	{
		for(int i = 0;i<index;i++)
			if(keyK.equals(pairs[0][1]))
				return (V)pairs[i][1];
		return null;
	}
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		for(int i =0;i<index;i++)
		{
			result.append(pairs[i][0].toString());
			result.append("-");
			result.append(pairs[i][1].toString());
			if(i<index-1)
				result.append("\n");
		}
		return result.toString();
	}
	public static void main(String args[])
	{
		
		AssociativeArray12<String, String> map = new AssociativeArray12<String, String>(3);
		map.put("s", "ss");
		map.put("P", "PP");
		map.put("T", "TT");
		try
		{
			map.put("Q", "QQ");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("太多了~");
		}
		System.out.println(map);
		System.out.println(map.get("T"));
		
			
		HashMap<String, String> map1 = new HashMap<String, String>(3);
		map1.put("s", "ss");
		map1.put("P", "PP");
		map1.put("T", "TT");
		try
		{
			map1.put("Q", "QQ");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("太多了~");
		}
		System.out.println(map1);
		System.out.println(map1.get("T"));
		
		
		TreeMap<String, String> map2 = new TreeMap<String, String>();
		map2.put("s", "ss");
		map2.put("P", "PP");
		map2.put("T", "TT");
		map2.put("r", "rr");
		map2.put("e", "ee");
		map2.put("wT", "ww");
		try
		{
			map2.put("Q", "QQ");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("太多了~");
		}
		System.out.println(map2);
		System.out.println(map2.get("T"));
		
		
		LinkedHashMap<String, String> map3 = new LinkedHashMap<String, String>();
		map3.put("s", "ss");
		map3.put("P", "PP");
		map3.put("T", "TT");
		try
		{
			map3.put("Q", "QQ");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("太多了~");
		}
		System.out.println(map3);
		System.out.print("按照顺序来");
		System.out.println(map3.get("T"));
	}
}
