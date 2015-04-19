/**
 * 文件名：Ex3.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-28
 */
package 第十七章深入研究容器;

import java.util.*;
import java.util.regex.*;
import net.mindview.util.*;
import static org.greggordon.tools.Print.*;

/**
 * @author 张文迪
 * 类名：Ex3
 * 类说明：
 */
public class Ex3 
{
	public static void main(String[] args) 
	{
		Set<String> hs = new HashSet<String>();
		Set<String> lhs = new LinkedHashSet<String>();
		Set<String> ts = new TreeSet<String>();
		System.out.println("HashSet hs = " + hs);
		System.out.println("LinkedHashSet lhs = " + lhs);
		System.out.println("TreeSet ts = " + ts);
		Map<String,String> hm = new HashMap<String,String>(0);
		Pattern p = Pattern.compile("Z[a-zA-Z]*");             //~~~~~~~~~
		for(int i = 0; i < Countries.DATA.length; i++)        //~~~~~
		{
			if(p.matcher(Countries.DATA[i][0]).matches())
			hm.put(Countries.DATA[i][0], Countries.DATA[i][0]);
		}
		System.out.println("hm.keySet() = " + hm.keySet());
		System.out.println("Adding hm.keySet()");
		hs.addAll(hm.keySet());
		lhs.addAll(hm.keySet());
		ts.addAll(hm.keySet());
		System.out.println("hs: " + hs);
		System.out.println("lhs: " + lhs);
		System.out.println("ts: " + ts);
		System.out.println("Adding 10 more times");
		for(int i = 0; i < 10; i++)    //图和拓展到更加一般的 情况~~ 如！counters.DATA 中的数~
		{
			hs.addAll(hm.keySet());
			lhs.addAll(hm.keySet());
			ts.addAll(hm.keySet());
		}
		System.out.println("hs: " + hs);
		System.out.println("lhs: " + lhs);
		System.out.println("ts: " + ts);				
	}
}
