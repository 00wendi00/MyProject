/**
 * �ļ�����Ex202.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���������о�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-28
 */
package ��ʮ���������о�����;

/**
 * @author ���ĵ�
 * ������Ex202
 * ��˵����
 */
import java.util.*;
import java.util.regex.*;
import net.mindview.util.*;


public class Ex202 
{
	public static void main(String[] args) 
	{
		Map<String,String> hm = new HashMap<String,String>();
		Set<String> hs = hm.keySet();   //~~  keySet(),keyValue()~~~
		Pattern p = Pattern.compile("A[a-zA-Z]*");  //"A.*"		
		for(int i = 0; i < Countries.DATA.length; i++) 
		{
			Matcher m = p.matcher(Countries.DATA[i][0]);   // ������ʽ~~�е� m.find();m.group()~
			if(p.matcher(Countries.DATA[i][0]).matches())
				hm.put(Countries.DATA[i][0], Countries.DATA[i][1]);
		}
		System.out.println(hm);	
		System.out.println(hs);	
	}
}
