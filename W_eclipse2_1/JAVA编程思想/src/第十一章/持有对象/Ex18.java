/**
 * 文件名：Ex18.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-9
 */
package 第十一章.持有对象;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author 张文迪
 * 类名：Ex18
 * 类说明：
 */
class Gerbil111 {
	private int gerbilNumber;
	public Gerbil111(int i) {
		gerbilNumber = i;
	}
	public void hop() {
		System.out.println("gerbil " + gerbilNumber + " hops");
	}
}

public class Ex18 {
	public static void main(String[] args) {
		Map<String, Gerbil111> gerbils = new HashMap<String, Gerbil111>();
		gerbils.put("Fuzzy", new Gerbil111(0));
		gerbils.put("Spot", new Gerbil111(1));
		gerbils.put("Speedy", new Gerbil111(2));
		gerbils.put("Dopey", new Gerbil111(3));
		gerbils.put("Sleepy", new Gerbil111(4));
		gerbils.put("Happy", new Gerbil111(5));
		gerbils.put("Funny", new Gerbil111(6));
		gerbils.put("Silly", new Gerbil111(7));
		gerbils.put("Goofy", new Gerbil111(8));
		gerbils.put("Wowee", new Gerbil111(9));
		System.out.println(gerbils);
		System.out.println(1);
		Set<String> sortedKeys = 
			new TreeSet<String>(gerbils.keySet());
		System.out.println(sortedKeys);
		System.out.println(2);
		Map<String, Gerbil111> sortedGerbils = 
			new LinkedHashMap<String, Gerbil111>();
		for(String s : sortedKeys) {
			System.out.print("Adding " + s + ", ");
			sortedGerbils.put(s, gerbils.get(s));			
		}
		System.out.println();
		System.out.println(3);
		System.out.println(sortedGerbils);
		System.out.println();
		// or, just:
		Map<String, Gerbil111> sortedGerbils2 =
			new TreeMap<String, Gerbil111>(gerbils);
		System.out.println(sortedGerbils2);	
		
		
		System.out.println(5);
		Set<String> sortedKeys2 = new HashSet<String>(gerbils.keySet());
		System.out.println(sortedKeys2);
		
		System.out.println(6);
		Set<String> sortedKeys3 = new LinkedHashSet<String>(gerbils.keySet());
		System.out.println(sortedKeys3);
		
		System.out.println(7);
	}
}

