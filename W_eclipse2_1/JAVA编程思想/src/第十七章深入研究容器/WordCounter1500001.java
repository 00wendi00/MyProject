/**
 * �ļ�����WordCounter15.java
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
 * ������WordCounter15
 * ��˵���� ��ϰ 15 ����������~~����
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
