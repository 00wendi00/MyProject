/**
 * 文件名：E20_SimpleHashMapCollisons.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-30
 */
package 第十七章深入研究容器;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import net.mindview.util.Countries;

/**
 * @author 张文迪
 * 类名：E20_SimpleHashMapCollisons
 * 类说明：
 */
class SimpleHashMap2<K,V> extends SimpleHashMap<K,V> 
{
	static int count = 0;
	@Override public V put(K key, V value) 
	{
		V oldValue = null;
		
		int index = Math.abs(key.hashCode()) % SIZE;
		MapEntry<K,V> pair = new MapEntry<K,V>(key, value);
		if(buckets[index] == null)
			buckets[index] = new LinkedList<MapEntry<K,V>>();
		// Lines added here:
		else 
		{
			count++;
			System.out.println("Collision while adding\n" + pair + "\nBucket already contains:");
			Iterator<MapEntry<K,V>> it = buckets[index].iterator();
			while(it.hasNext())
			System.out.println(it.next());
			System.out.println(count+"~~~~~~~~~~~~~~~~");
		}
	// End of lines added
		LinkedList<MapEntry<K,V>> bucket = buckets[index];
	    boolean found = false;
	    ListIterator<MapEntry<K,V>> it = bucket.listIterator();
	    while(it.hasNext()) 
	    {
	    	MapEntry<K,V> iPair = it.next();
	    	if(iPair.getKey().equals(key)) 
	    	{
	    		oldValue = iPair.getValue();
	    		it.set(pair); // Replace old with new
	    		found = true;
	    		break;
	    	}
	    }
		if(!found)
			buckets[index].add(pair);
		return oldValue;
	}
}

public class E20_21_SimpleHashMapCollisons 
{
	public static void main(String[] args) 
	{
		SimpleHashMap2<String,String> m = null;
		for(int i = 0;i<Countries.DATA.length;i++)
		{
			m = new SimpleHashMap2<String,String>();
			m.putAll(Countries.capitals(i));
			if(SimpleHashMap2.count!=0)
			{
				System.out.println(i+"~~~~~~~~~~~~~~~~");
				break;
			}
		}
		//m.putAll(Countries.capitals(10));
		System.out.println(m);
	}
}