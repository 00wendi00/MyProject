/**
 * �ļ�����SimpleCollection.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-29
 */
package ��ʮһ��.���ж���;

import java.util.*;


/**
 * @author ���ĵ�
 * ������SimpleCollection
 * ��˵���� ��ϰ2
 */
public class SimpleCollection
{
    public static void main(String args[])
    {
    	//Collection<Integer> q = new ArrayList<Integer>();
    	Set<Integer> c = new HashSet<Integer>();
    	for(int i = 0;i<8;i++)
    		c.add(i);
    	for(Integer i : c)
    		System.out.print(i+", ");
    }
}
