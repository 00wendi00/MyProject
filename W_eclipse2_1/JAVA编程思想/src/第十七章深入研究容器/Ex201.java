/**
 * �ļ�����Ex2.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���������о�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-28
 */
package ��ʮ���������о�����;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.mindview.util.Countries;

/**
 * @author ���ĵ�
 * ������Ex2
 * ��˵�����ȴ���List����sort()~������List.get(index)һ����matches~~
 */
public class Ex201
{
	public static void main(String args[])
	{
		List<String> l = new ArrayList<String>();
		for(int i = 0;i<Countries.DATA.length;i++)
			l.add(Countries.DATA[i][0]);
		System.out.println(l);
		Collections.sort(l);
		System.out.println(l);
		
		for(int i = 0;i<Countries.DATA.length;i++)
		{			
			if(l.get(i).matches("A.*"))	
				System.out.print(l.get(i)+";");
			else 
			{
				break;
			}
		}
	}
}
