/**
 * �ļ�����Ex4.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���������о�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-28
 */
package ��ʮ���������о�����;

/**
 * @author ���ĵ�
 * ������Ex4
 * ��˵���� ��δ��ļ�������  IO����ѧϰ~~
 */
import java.util.*;
import net.mindview.util.*;
import static org.greggordon.tools.Print.*;

public class Ex4 
{
	static Collection<String> CollectFromText(String fileName) 
	{		
		String[] sa = TextFile.read(fileName).split(" ");
		return Arrays.asList(sa);
	}
	static Collection<String> CollectFromText2(String fileName) 
	{		
		String[] sa = TextFile.read(fileName).split(" ");
		return new TreeSet<String>(new TextFile(fileName����, "\\W+"));
	}
	public static void main(String[] args) 
	{
		println(CollectFromText("Ex4.java"));
		println(CollectFromText2("Ex4.java"));
	}
}