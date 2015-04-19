/**
 * 文件名：CountingMapData5.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-28
 */
package 第十七章深入研究容器;

/**
 * @author 张文迪
 * 类名：CountingMapData5
 * 类说明：定制 EntrySet类~ 实现完全享元 //   这个例子很重要！！！！！！！！！！！！！！
 */
import java.util.*;
import net.mindview.util.*;
import static org.greggordon.tools.Print.*;

public class CountingMapData5 extends AbstractMap<Integer,String> 
{	
  	private static String[] chars =
    		"A B C D E F G H I J K L M N O P Q R S T U V W X Y Z"
    		.split(" ");
	static class Entry implements Map.Entry<Integer,String> 
	{
    		int index;
    		Entry(int index) { this.index = index; }
    		public boolean equals(Object o) 
    		{
      			return Integer.valueOf(index).equals(o);
    		}
    		public Integer getKey() { return index; }
    		public String getValue() 
    		{
			return chars[index % chars.length] +
        			Integer.toString(index / chars.length);
    		}
    		public String setValue(String value) 
    		{
      			throw new UnsupportedOperationException();
    		}
    		public int hashCode() 
    		{
      			return Integer.valueOf(index).hashCode();
    		}
  	}
	// Use AbstractSet by implementing size() & iterator()
    	static class EntrySet extends AbstractSet<Map.Entry<Integer,String>> 
    	{
    		private int size;
      		EntrySet(int size) 
      		{
			if(size < 0) this.size = 0;
			else this.size = size;
        	}
      		public int size() { return size; }
      		private class Iter implements Iterator<Map.Entry<Integer,String>> 
      		{
        		// Only one Entry object per Iterator:
        		private Entry entry = new Entry(-1);
        		public boolean hasNext() 
        		{
        			return entry.index < size - 1;
        		}
        			public Map.Entry<Integer,String> next() 
        		{
        			entry.index++;
          			return entry;
        		}
        		public void remove() 
        		{
          			throw new UnsupportedOperationException();
        		}
      		}
      		public Iterator<Map.Entry<Integer,String>> iterator() 
      		{
      			return new Iter();
      		}			
    	}
	private static Set<Map.Entry<Integer,String>> entries = new EntrySet(chars.length);
	public Set<Map.Entry<Integer,String>> entrySet() { return entries; }
	static Map<Integer,String> select(final int size)    // 返回 ，EntrySet 的   CountingMapData5~~~~
	{
    		return new CountingMapData5() 
    		{
      			public Set<Map.Entry<Integer,String>> entrySet() 
      			{
        			return new EntrySet(size);  
      			}
    		};
  	}	
	public static void main(String[] args) 
	{
		System.out.println(new CountingMapData5());
		System.out.println(select(4));
		System.out.println(select(6));
	}
} 
