/**
 * �ļ�����Ex7.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���������о�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-28
 */
package ��ʮ���������о�����;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import net.mindview.util.Countries;

/**
 * @author ���ĵ�
 * ������Ex7
 * ��˵����      // ����Iterator ��   ListIterator���ı��˵ײ�����ݽṹ~~~ al���� ����Ҳ������ �������������������������� 
 */
public class Ex7
{
	public static void main(String args[])
	{
		ArrayList<String>  al = new ArrayList<String>();
		LinkedList<String> kl = new LinkedList<String>();
		al.addAll(Countries.names(6));
		kl.addAll(Countries.names(5));
		System.out.println(al);
		System.out.println(kl);
		
		Iterator<String> at = al.iterator();
		Iterator<String> kt = kl.iterator();
		while(at.hasNext())
			System.out.print(at.next()+" ");
		System.out.println();
		while(kt.hasNext())
			System.out.print(kt.next()+" ");
		System.out.println();
		
		ListIterator lat = al.listIterator();
		ListIterator lkt = kl.listIterator();

		while(lkt.hasNext())
		{
			lkt.next();
		}
		while(lat.hasNext())
		{
			lat.next();
		}
		while(lkt.hasPrevious())
		{
			lat.add(lkt.previous());
			lat.previous();
			lat.previous();
		}
		System.out.println(al); 
		       // ����Iterator ��   ListIterator���ı��˵ײ�����ݽṹ~~~ al���� ����Ҳ������ ��������������������������
	}
}
