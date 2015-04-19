/**
 * �ļ�����Ex17.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @author ���ĵ�
 * ������Ex17
 * ��˵����
 */
public class Ex17 
{
	public static void main(String[] args) 
	{
		Map<Character,Integer> charsStat =
				new HashMap<Character,Integer>();
		for(String word :
			new TextFile("C:/Users/���ĵ�/Desktop/�½��ļ���1/2.txt", "\\W+"))
			for(int i = 0; i < word.length(); i++) 
			{
				Character ch = word.charAt(i);	
				Integer freq = charsStat.get(ch);
				charsStat.put(ch, freq == null ? 1 : freq + 1);  // ����~~ 
			}
		List<Character> keys = Arrays.asList(
			charsStat.keySet().toArray(new Character[0]));    //��һ������
		Collections.sort(keys);   //��Ȼ���� ~~~
		for(Character key : keys)
		System.out.println(key + " �� " + charsStat.get(key));
	}
}
