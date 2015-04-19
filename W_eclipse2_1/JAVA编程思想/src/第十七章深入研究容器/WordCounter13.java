/**
 * 文件名：WordCounter13.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-29
 */
package 第十七章深入研究容器;

/**
 * @author 张文迪
 * 类名：WordCounter13
 * 类说明：
 */
import net.mindview.util.*;	
import static net.mindview.util.Print.*;
import java.util.*;

public class WordCounter13 
{
	public static void main(String[] args) 
	{
		// File whose words are to be counted:
		String fileName = "WordCounter13.java";
		// Set of unique words in file:
		Set<String> words = new TreeSet<String>(new TextFile(fileName, "\\W+"));
		// Create initialize array of correct length:
		AssociativeArray12<String,Integer> wordCount =
			new AssociativeArray12<String,Integer>(words.size());
		// Word list of all words in file:
		ArrayList<String> fileList = new TextFile(fileName, "\\W+");
		// Count appearances of each unique word and add to array:
		for(String s : words) 
		{
			int count = 0;
			for(String t : fileList) 
			{
				if(t.equals(s)) count++;
			}
			wordCount.put(s, count);
		}
		print(wordCount);
	}
}