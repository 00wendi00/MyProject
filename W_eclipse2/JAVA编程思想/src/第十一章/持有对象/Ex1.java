/**
 * �ļ�����Ex1.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-29
 */
package ��ʮһ��.���ж���;

import java.util.ArrayList;


/**
 * @author ���ĵ�
 * ������Ex1
 * ��˵����
 */
class Gerbil
{
	private  static int gerbilNumber = 1 ;
	private  final int id = gerbilNumber++ ;
	Gerbil(String s)
	{
		System.out.println(s);
	}
	public String hop()
	{
		return id +" ��~~~~~~" ;
	}	
	public String toString()
	{
		return id +" ��!!!!!!!!!!" ;
	}
	
}
public class Ex1
{
     public static void main(String args[])
     {
    	 ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
    	 for(int i = 0;i<5;i++)
    		 gerbils.add(new Gerbil("funny"));
    	 for(int i =0;i<gerbils.size();i++)
    		 System.out.println(gerbils.get(i).hop());
    	 
    	 System.out.println();
    	 
    	 for(Gerbil g : gerbils)
    		 System.out.println(g.toString());
     }
}
