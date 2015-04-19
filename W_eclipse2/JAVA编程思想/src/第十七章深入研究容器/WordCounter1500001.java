/**
 * 文件名：WordCounter15.java
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
 * 类名：WordCounter15
 * 类说明： 练习 15 遍历了两遍~~，，
 */
public class WordCounter1500001
{
	public static void main(String args[])
	{
		String fileName = "WordCounter13.java";
		Set<String> words = new TreeSet<String>(new TextFile(fileName, "\\W+"));
		ArrayList<String> fileList = new TextFile(fileName, "\\W+");
		SlowMap<String,Integer> sm = new SlowMap<String, Integer>();
		for(String s: words)
		{
			int count = 0;
			for(String k : fileList)
			{
				if(s.equals(k)) count++;
			}
			sm.put(s, count);
		}
		print(sm);
	}
}
