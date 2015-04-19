/**
 * 文件名：Ex24.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-9
 */
package 第十一章.持有对象;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author 张文迪
 * 类名：Ex24
 * 类说明：
 */
public class Ex24
{	
	public static void main(String[] args) 
	{
		Map<String,Integer> m = 
			new LinkedHashMap<String,Integer>();
		m.put("ten", 10);
		m.put("nine", 9);
		m.put("eight", 8);
		m.put("seven", 7);
		m.put("six", 6);
		m.put("five", 5);
		m.put("four", 4);
		m.put("three", 3);
		m.put("two", 2);
		m.put("one", 1);
		m.put("zero", 0);
		System.out.println("Map to sort: " + m);
		// temporary map to hold entrys:
		Map<String,Integer> mTemp = 
			new LinkedHashMap<String,Integer>();
		// use TreeSet to sort the keySet():
		Set<String> ss = new TreeSet<String>(m.keySet());
		// mover sorted keys to temp map:
		Iterator<String> itss = ss.iterator();
		while(itss.hasNext()) 
		{
			String s = (String)itss.next();
			Integer i = m.get(s);
			m.remove(s);
			mTemp.put(s, i);
		}
		// get sorted list of temp keys:
		Set<String> ssTemp = 
			new TreeSet<String>(mTemp.keySet());
		// move sorted entrys back to map:
		Iterator<String> itssTemp = ssTemp.iterator();
		while(itssTemp.hasNext()) 
		{
			String s = (String)itssTemp.next();
			Integer i = mTemp.get(s);
			mTemp.remove(s);
			m.put(s, i);
		}
		// done with temp:
		mTemp.clear();
		System.out.println("Sorted map: " + m);
	}
}
