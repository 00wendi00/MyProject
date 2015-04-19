/**
 * �ļ�����WordCounter1500002.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���������о�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-29
 */
package ��ʮ���������о�����;

import net.mindview.util.*;	
import static net.mindview.util.Print.*;
import java.util.*;

/**
 * @author ���ĵ�
 * ������WordCounter1500002
 * ��˵���� ��ϰ15  ������һ��~~~���� ������map�����ԣ� ��Ψһ��ֵ���Բ�Ψһ~~     ����Iterator.hasNext()�жϣ�next()����~~ ���ã�����
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
