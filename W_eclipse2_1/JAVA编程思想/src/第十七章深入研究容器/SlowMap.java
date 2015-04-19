/**
 * 文件名：SlowMap.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-29
 */
package 第十七章深入研究容器;

import java.util.AbstractMap;
import java.util.*;
import net.mindview.util.*;
/**
 * @author 张文迪
 * 类名：SlowMap
 * 类说明：
 */
public class SlowMap<K,V> extends AbstractMap<K,V> {
	  private List<K> keys = new ArrayList<K>();
	  private List<V> values = new ArrayList<V>();
	  public V put(K key, V value) {
	    V oldValue = get(key); // The old value or null
	    if(!keys.contains(key)) {
	      keys.add(key);
	      values.add(value);
	    } else
	      values.set(keys.indexOf(key), value);
	    return oldValue;
	  }
	  public V get(Object key) { // key is type Object, not K
	    if(!keys.contains(key))
	      return null;
	    return values.get(keys.indexOf(key));
	  }
	  public Set<Map.Entry<K,V>> entrySet() {
	    Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
	    Iterator<K> ki = keys.iterator();
	    Iterator<V> vi = values.iterator();
	    while(ki.hasNext())
	      set.add(new MapEntry<K,V>(ki.next(), vi.next()));
	    return set;
	  }
	  public static void main(String[] args) {
	    SlowMap<String,String> m= new SlowMap<String,String>();
	    m.putAll(Countries.capitals(15));
	    System.out.println(m);
	    System.out.println(m.get("BULGARIA"));
	    System.out.println(m.entrySet());
	  }
	}
