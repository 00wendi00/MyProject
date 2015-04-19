/**
 * 文件名：Ex16.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-8
 */
package 第十一章.持有对象;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author 张文迪
 * 类名：Ex16
 * 类说明： addAll~~~~~    +    contains~~~
 */


public class Ex16 {
	static void vowelCounter(Set<String> st) 
	{
		Set<Character> vowels = new TreeSet<Character>();
		Collections.addAll(vowels, 
			'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
		System.out.println(vowels);
		int allVowels = 0;
		for(String s : st) 
		{
			int count = 0;
			for(Character v : s.toCharArray()) 
			{		
				if(vowels.contains(v)) 
				{
					count++;
					allVowels++; 
				}
			}
			System.out.print(s + ": " + count + ", ");		
		}
		System.out.println();	
		System.out.print("Total vowels: " + allVowels);
	}
	public static void main(String[] args) 
	{
		Set<String> words = 
			new TreeSet<String>(Arrays.asList("A b c d U o i"));
		System.out.println(words);
		System.out.println();
		Ex16.vowelCounter(words);	
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('a', 0);
		map.put('e', 0);
		map.put('i', 0);
		map.put('o', 0);
		map.put('u', 0);
		map.put('A', 0);
		map.put('E', 0);
		map.put('I', 0);
		map.put('O', 0);
		map.put('U', 0);
		
		System.out.println(map);
	}		
}