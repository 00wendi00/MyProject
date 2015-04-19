/**
 * 文件名：Ex17.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @author 张文迪
 * 类名：Ex17
 * 类说明：
 */
public class Ex17 
{
	public static void main(String[] args) 
	{
		Map<Character,Integer> charsStat =
				new HashMap<Character,Integer>();
		for(String word :
			new TextFile("C:/Users/张文迪/Desktop/新建文件夹1/2.txt", "\\W+"))
			for(int i = 0; i < word.length(); i++) 
			{
				Character ch = word.charAt(i);	
				Integer freq = charsStat.get(ch);
				charsStat.put(ch, freq == null ? 1 : freq + 1);  // 精髓~~ 
			}
		List<Character> keys = Arrays.asList(
			charsStat.keySet().toArray(new Character[0]));    //这一步！！
		Collections.sort(keys);   //自然升序 ~~~
		for(Character key : keys)
		System.out.println(key + " ： " + charsStat.get(key));
	}
}
