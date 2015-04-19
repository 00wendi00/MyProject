/**
 * 文件名：MapEntry.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-29
 */
package 第十七章深入研究容器;

/**
 * @author 张文迪
 * 类名：MapEntry
 * 类说明：
 */
import java.util.*;

public class MapEntry<K,V> implements Map.Entry<K,V> 
{
  private K key;
  private V value;
  public MapEntry(K key, V value) 
  {
    this.key = key;
    this.value = value;
  }
  public K getKey() { return key; }
  public V getValue() { return value; }
  public V setValue(V v) 
  {
    V result = value;
    value = v;
    return result;
  }
  public int hashCode() 
  {
    return (key==null ? 0 : key.hashCode()) ^
      (value==null ? 0 : value.hashCode());
  }
  public boolean equals(Object o) 
  {
    if(!(o instanceof MapEntry)) return false;
    MapEntry me = (MapEntry)o;
    return
      (key == null ?
       me.getKey() == null : key.equals(me.getKey())) &&
      (value == null ?
       me.getValue()== null : value.equals(me.getValue()));
  }
  public String toString() { return key + "=" + value; }
}
