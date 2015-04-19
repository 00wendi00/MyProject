/**
 * 文件名：Ex20.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-9
 */
package 第十一章.持有对象;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author 张文迪
 * 类名：Ex20
 * 类说明：
 */
public class Ex20 {
	static void vowelCounter20(Set<String> st) 
	{		
		Set<Character> vowels = new TreeSet<Character>();
		Collections.addAll(vowels, 
			'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
		int allVowels = 0;
		Map<Character,Integer> vowelMap =
			new TreeMap<Character,Integer>();
		for(String s : st) 
		{
			for(Character v : s.toCharArray()) 
			{		
				if(vowels.contains(v))
				{
					Integer count = vowelMap.get(v);
					vowelMap.put(v, 
						count == null ? 1 : count + 1);  //~!!!!!!!!!!!!
					allVowels++; 
				}
			}
		}
		System.out.println("Vowels: " + vowelMap);	
		System.out.println("Total vowels: " + allVowels);
	}
	public static void main(String[] args)
	{
		Set<String> words = 		
			new TreeSet<String>(Arrays.asList("a","b","U","U","U"));
		System.out.println(words);
		System.out.println();
		vowelCounter20(words);		
	}		
}
