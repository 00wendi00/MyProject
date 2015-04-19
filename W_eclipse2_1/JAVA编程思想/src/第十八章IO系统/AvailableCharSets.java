/**
 * �ļ�����AvailableCharSets.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-2
 */
package ��ʮ����IOϵͳ;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;
import static net.mindview.util.Print.*;

/**
 * @author ���ĵ�
 * ������AvailableCharSets
 * ��˵����
 */
public class AvailableCharSets
{
	public static void main(String args[])
	{
		SortedMap<String, Charset> charSets = Charset.availableCharsets();
						//16 λ�� Unicode ���뵥Ԫ���к��ֽ�����֮���ָ��ӳ���ϵ
		Iterator<String> it = charSets.keySet().iterator();
		while(it.hasNext())
		{
			String csName = it.next();
			printnb(csName);
			Iterator aliases = charSets.get(csName).aliases().iterator();
												//���ذ����� charset ���������ļ���
			if(aliases.hasNext())
				printnb(": ");
			while(aliases.hasNext())
			{
				printnb(aliases.next());
				if(aliases.hasNext())
					System.out.print(", ");
			}
		}
	} 					
}
