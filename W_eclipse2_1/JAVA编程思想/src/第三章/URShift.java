/**
 * �ļ�����URShift.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-3
 */
package ������;

import ��һ����.Print;

/**
 * @author ���ĵ�
 * ������URShift
 * ��˵������λ������
 */
public class URShift
{
    public static void main(String args[])
    {
    	int i = -1;
    	System.out.println(~i);
    	System.out.println(i);
    	System.out.println(Integer.toBinaryString(i));
    	i>>>= 10;
    	System.out.println(i);
    	System.out.println(Integer.toBinaryString(i));
    	System.out.println();
    	
    	byte b=-1;
    	System.out.println(Integer.toBinaryString(b));
    	b >>>= 10;
    	System.out.println(b);
    	System.out.println(Integer.toBinaryString(b));
    	System.out.println(Integer.toBinaryString(b>>>10));   	    	   	   	

    	
    }
}



