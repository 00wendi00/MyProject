/**
 * �ļ�����Ex8.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-1
 */
package ��ʮһ��.���ж���;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author ���ĵ�
 * ������Ex8
 * ��˵���� ��ϰ8�� ��������  Iterator
 */

public class Ex8
{
     public static void main(String args[])
     {
    	 ArrayList<Gerbil1> gerbils = new ArrayList<Gerbil1>();
    	 for(int i = 0;i<5;i++)
    		 gerbils.add(new Gerbil1());
    	 Iterator<Gerbil1> it = gerbils.iterator();
    	 while(it.hasNext())
    	 {
    		 Gerbil1 ge = it.next();
    		 
    	 } 
    	 System.out.println();
    	 System.out.println();
    	 for(Gerbil1 g : gerbils)
    		 System.out.println(g);
     }
}
