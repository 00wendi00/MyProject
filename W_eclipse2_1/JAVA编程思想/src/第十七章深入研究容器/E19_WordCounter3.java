/**
 * 文件名：E19_WordCounter3.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-30
 */
package 第十七章深入研究容器;

/**
 * @author 张文迪
 * 类名：E19_WordCounter3
 * 类说明：
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
			map.put(word, freq == null ? 1 : freq + 1);  // integer 没个给值 用 null
		}
		System.out.println(map);
}
}
