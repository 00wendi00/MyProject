/**
 * �ļ�����Ex17.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-9
 */
package ��ʮһ��.���ж���;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author ���ĵ�
 * ������Ex17
 * ��˵����  Map<~,~>   ~~~   
 */
public class Ex17
{
	public static void main(String[] args) 
	{
		Map<String, Gerbil2> gerbils = new HashMap<String, Gerbil2>();
		gerbils.put("Fuzzy", new Gerbil2(0));
		gerbils.put("Spot", new Gerbil2(1));
		gerbils.put("Speedy", new Gerbil2(2));
		gerbils.put("Dopey", new Gerbil2(3));
		gerbils.put("Sleepy", new Gerbil2(4));
		gerbils.put("Happy", new Gerbil2(5));
		Iterator<String> it = gerbils.keySet().iterator();
		while(it.hasNext()) 
		{
			String s = it.next();
			System.out.print(s + ": ");
			gerbils.get(s).hop();
		}	
	}
}
class Gerbil2 {
	private int gerbilNumber;
	public Gerbil2(int i) 
	{
		gerbilNumber = i;
	}
	public void hop() 
	{
		System.out.println("gerbil2 " + gerbilNumber + " hops");
	}
}
