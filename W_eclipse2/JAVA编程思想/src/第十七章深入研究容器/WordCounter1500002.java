/**
 * 文件名：WordCounter1500002.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-29
 */
package 第十七章深入研究容器;

import net.mindview.util.*;	
import static net.mindview.util.Print.*;
import java.util.*;

/**
 * @author 张文迪
 * 类名：WordCounter1500002
 * 类说明： 练习15  遍历了一遍~~~，， 利用率map的特性， 键唯一，值可以不唯一~~     利用Iterator.hasNext()判断，next()遍历~~ 极好！！！
 */
public class WordCounter1500002
{
	public static void main(String args[])
	{
		String fileName = "WordCounter15.java";
		// List of all words in file:
		ArrayList<String> wordList = new TextFile(fileName, "\\W+");
		SlowMap<String,Integer> wordCount = new SlowMap<String,Integer>();
		Iterator it = wordList.iterator();
		while(it.hasNext())
		{
			String s = (String)it.next();
			if(!(wordCount.containsKey(s)))
				wordCount.put(s,1);
			else 
			{
				int count = wordCount.get(s);
				wordCount.put(s, ++count);
			}
		}
		print(wordCount);
	}
}
