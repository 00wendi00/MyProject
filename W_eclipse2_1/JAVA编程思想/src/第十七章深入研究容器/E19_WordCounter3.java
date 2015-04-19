/**
 * �ļ�����E19_WordCounter3.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���������о�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-30
 */
package ��ʮ���������о�����;

/**
 * @author ���ĵ�
 * ������E19_WordCounter3
 * ��˵����
 */
import java.util.*;
import net.mindview.util.*;

public class E19_WordCounter3 
{
	public static void main(String[] args) 
	{
		List<String> words = new TextFile("WordCounter15.java", "\\W+");
		SimpleHashMap<String,Integer> map = new SimpleHashMap<String,Integer>();
		for(String word : words) 
		{
			Integer freq = map.get(word);
			map.put(word, freq == null ? 1 : freq + 1);  // integer û����ֵ �� null
		}
		System.out.println(map);
}
}
