/**
 * �ļ�����Rodent.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-1
 */
package ��ʮһ��.���ж���;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author ���ĵ�
 * ������Rodent
 * ��˵���� ��ϰ10.
 */
abstract public class Rodent
{
   protected static long m = 0;
   public static void main(String args[])
   {
	   ArrayList<Rodent> rodent000 = new ArrayList<Rodent>();
	   rodent000.add(new Mouse());
	   rodent000.add(new Gerbil1());
	   rodent000.add(new Hamster());
	 
	   System.out.println(m);
	   
	   System.out.println(m+"  ���ü�����  �������");
	   
	   Iterator<Rodent> it = rodent000.iterator();
	   while(it.hasNext())
	   {
		   Rodent r = it.next();
		   System.out.println(r);
		   r.Howl();
		   System.out.println();
	   }
   }
   public void Howl()
   {
	   System.out.println("֨֨֨֨������");
   }
  
  
   public Rodent()
   {
	   m++;
	   System.out.println("���౻��ʼ��");
	   System.out.println(m);
   }
}
class Mouse extends Rodent
{
	public void Howl()
	{
		m++;
		System.out.println("��������������");
	}
	public Mouse()
	{
		m++;
		System.out.println("���౻��ʼ��");
	}
}
class Gerbil1 extends Rodent
{
	public Gerbil1()
	{
		
	}

	public void Howl()
	{
		m++;
		System.out.println("�������룡����");
	}
}
class Hamster extends Rodent
{
	public void Howl()
	{
		m++;
		System.out.println("�ǺǺǺǣ�����");
	}
}
