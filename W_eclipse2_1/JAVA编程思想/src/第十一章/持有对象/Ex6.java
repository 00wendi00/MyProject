/**
 * 文件名：Ex6.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-9-29
 */
package 第十一章.持有对象;

import java.util.*;

import javax.security.auth.x500.X500Principal;

/**
 * @author 张文迪
 * 类名：Ex6
 * 类说明：
 */
public class Ex6 {
	public static void main(String[] args) {
		Random rand = new Random();
		List<String> ls = new ArrayList<String>();
		print("0: " + ls);
		Collections.addAll(ls, "oh", "what", "a", "beautiful", "Manila", "Monday", "morning");
		print("1: " + ls);
		String h = new String("hi");
		ls.add(h);
		print("2: " + ls);
		print("3: " + ls.contains(h));
		// removes the first instance equivalent to String h:
		ls.remove(h);
		print("3.5: " + ls);
		String p = ls.size() > 2 ? ls.get(2) : null;  //判断大小 ~~~~
		print("4: " + p + " " +  ls.indexOf(p));
		String cy = new String("cy");
		print("5: " + cy +" " + ls.indexOf(cy)); //列表中没有~输出 -1
		print("6: " + ls.remove(cy));
		print("7: " + ls.remove(p));
		print("8: " + ls);
		if(ls.size() > 3)
			ls.add(3, "wonderful");
		print("9: " + ls);
		if(ls.size() > 4) {
			List<String> s = 
			   Arrays.asList("let's", "jump", "in", "here");
			ls.addAll(0, s);
		}
		print("9.5"+ls);
		List<String> sub = ls.subList(1, 4); //   1<=  X <4  
		print("sublist: " + sub);
		print("10: " + ls.containsAll(sub));
		// will also sort sub elements within ls:
		Collections.sort(sub);
		print("sorted sublist: " + sub);
		print("11: " + ls.containsAll(sub));
		print("11.25: " + ls);
		// will also shuffle sub elements within ls:
		Collections.shuffle(sub, rand);
		print("11.5: " + ls);
		print("shuffled sublist: " + sub);
		print("12: " + ls.containsAll(sub));
		List<String> copy = new ArrayList<String>(ls);
		print("12.5: " + ls);
		if(ls.size() < 5) {
			ls.add("two");
			ls.add("more");
		}
		sub = Arrays.asList(ls.get(1), ls.get(4));
		print("sub: " + sub);	
		copy.retainAll(sub);
		print("13: " + copy);
		copy = new ArrayList<String>(ls);
		copy.remove(2);
		print("14: " + copy);
		copy.removeAll(sub); 
		print("15: " + copy);
		if(copy.size() > 1) // to avoid out of bounds exception
			copy.set(1, "excellent"); 
		print("16: " + copy);
		if(copy.size() > 2)
			copy.addAll(2, sub);
		print("17: " + copy);
		print("18: " + ls.isEmpty());
		ls.clear();
		print("19: " + ls);
		print("20: " + ls.isEmpty());
		ls.addAll(0, sub);
		ls.addAll(2,sub);
		//ls.addAll(sub);
		print("21: " + ls);
		Object[] o = ls.toArray();
		print("22: " + o[3]);
		String[] sa = ls.toArray(new String[0]);
		print("23: " + sa[3]);
	}
	private static void print(String string)
	{
		System.out.println(string);		
	}
}