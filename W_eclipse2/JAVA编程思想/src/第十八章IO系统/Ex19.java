/**
 * �ļ�����Ex19.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-2
 */
package ��ʮ����IOϵͳ;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ���ĵ�
 * ������Ex19
 * ��˵����
 */
public class Ex19
{
	public static void main(String args[]) throws IOException
	{
		Map<Byte, Integer> map = new  HashMap<Byte, Integer>();
		byte[] by = BinaryFile.read("C:/Users/���ĵ�/Desktop/�½��ļ���1/5.txt");
		for(int i = 0;i<by.length;i++)
		{
			Integer k = map.get(by);
			map.put(by[i], k==null ? 1:k+1);
		}
		System.out.println(map.containsKey('6'));
		
	//	for(int i = 0;i<by.length;i++)
		//	System.out.println(Byte.toString(by[i]));
		
		System.out.println(map);
	}
}
