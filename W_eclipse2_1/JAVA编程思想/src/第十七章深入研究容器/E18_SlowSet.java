/**
 * 文件名：E18_SlowSet.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-30
 */
package 第十七章深入研究容器;

/**
 * @author 张文迪
 * 类名：E18_SlowSet
 * 类说明：
 */
import java.util.*;
import net.mindview.util.*;

class SlowSet<K> extends AbstractSet<K> 
{
	private List<K> keys = new ArrayList<K>();
	public boolean add(K key)
	{
		if(!contains(key)) 
		{
			keys.add(key);
			return true;
		}
		return false;
	}
	public Iterator<K> iterator() { return keys.iterator(); }
	public int size() { return keys.size(); }
}

public class E18_SlowSet 
{
	public static void main(String[] args) 
	{
		SlowSet<String> slowSet = new SlowSet<String>();
		slowSet.addAll(Countries.names(10));
		slowSet.addAll(Countries.names(10));
		slowSet.addAll(Countries.names(10));
		System.out.println(slowSet);
	}
}
