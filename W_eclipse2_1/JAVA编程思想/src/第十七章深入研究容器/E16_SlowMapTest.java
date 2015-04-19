/**
 * 文件名：Ex16.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-30
 */
package 第十七章深入研究容器;

import java.util.Map;

import net.mindview.util.CountingMapData;

/**
 * @author 张文迪
 * 类名：Ex16
 * 类说明：
 */
public class E16_SlowMapTest 
{
	public static void printKeys(Map<Integer,String> map) 
	{
		System.out.println("Size = " + map.size() + ", ");
		System.out.println("Keys: ");
		System.out.println(map.keySet()); // Produce a Set of the keys
	}
	public static void test(Map<Integer,String> map) 
	{
		System.out.println(map.getClass().getSimpleName());
		map.putAll(new CountingMapData(10));
		// Map has 'Set' behavior for keys:
		map.putAll(new CountingMapData(10));
		printKeys(map);
		// Producing a Collection of the values:
		System.out.println("Values: ");
		System.out.println(map.values());
		System.out.println(map);
		System.out.println("map.containsKey(11): " + map.containsKey(11));
		System.out.println("map.get(11): " + map.get(11));
		System.out.println("map.containsValue(\"F0\"): "
				+ map.containsValue("F0"));
		Integer key = map.keySet().iterator().next();
		System.out.println("First key in map: " + key);
		map.remove(key);



		printKeys(map);
		map.clear();
		for(int i = 0;i<map.size();i++)
		{
			map.remove(map.keySet());
			map.clear();
			System.out.println(map);
		}
		System.out.println("map.isEmpty(): ~~~" + map.isEmpty());
		map.putAll(new CountingMapData(25));
		// Operations on the Set change the Map:
		map.keySet().removeAll(map.keySet());
		System.out.println("map.isEmpty(): " + map.isEmpty());
	}
	public static void main(String[] args) 
	{
		System.out.println("Testing SlowMap");
		test(new SlowMap<Integer,String>());
		//System.out.println("Testing SlowMap2");
		//test(new SlowMap2<Integer,String>());
	}
}
