/**
 * �ļ�����Test.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���������о�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-30
 */
package ��ʮ���������о�����;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ���ĵ�
 * ������Test
 * ��˵����
 */
public class Test00
{
	public static void main(String args[])
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("~", 1);
		map.put("!", 2);
		map.put("@", 3);
		System.out.println(map);
		map.clear();
		System.out.println(map);
	}
}
