/**
 * �ļ�����E18_SlowSet.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���������о�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-30
 */
package ��ʮ���������о�����;

/**
 * @author ���ĵ�
 * ������E18_SlowSet
 * ��˵����
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
