/**
 * �ļ�����Ex1.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����ö������
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-3
 */
package ��ʮ����ö������;

/**
 * @author ���ĵ�
 * ������Ex1
 * ��˵����
 */

import static ��ʮ����ö������.Signal.*;
public class Ex1
{
	Signal color = Signal.RED;
	public void change()
	{
		switch(color)
		{
		   case RED: color = GREEN; break;
		   case GREEN : color = YELLOW;  break;
		   case YELLOW : color = RED;break;
		}
	}
	public String toString()
	{
		return color+" ";
	}
	public static void main(String args[])
	{
	     Ex1 e = new Ex1();
	     for(int i= 0;i<10;i++)
	     {	  	  
	    	 System.out.println(e);
	         e.change();
	     }
	}
}
