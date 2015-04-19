/**
 * �ļ�����Ex25.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-27
 */
package ��ʮ��������;

import java.util.*;
import static net.mindview.util.Print.*;


/**
 * @author ���ĵ�
 * ������Ex25
 * ��˵����  ���õ�����~~~ListIterator  ����     ~~~~�� hasPrevious ʵ�� ����
 */
class MyList extends ArrayList<Integer> 
{
	List myList = new ArrayList();
	MyList(List l) { myList = l; }
	@SuppressWarnings("unchecked")
	MyList getReversed() 
	{
		ListIterator lit = myList.listIterator(myList.size());
		List reverseMyList = new ArrayList();
		while(lit.hasPrevious()) 
		{
			reverseMyList.add(lit.previous());
		}
		return new MyList(reverseMyList);   //�� hasPrevious ʵ�� ����
	}
}

public class Ex25 
{
	public static void main(String[] args) 
	{
		List<Integer> aList = 
			new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		print(aList);
		print(aList.get(4));
		aList.add(new Integer(6));
		//aList.addAll(new ArrayList<Integer>(Arrays.asList(7,8)));
		aList.addAll(Arrays.asList(7,8));
		print(aList);
		print(aList.subList(2,4));
		MyList ml = new MyList(aList);
		print((ml.getReversed()).myList);
	}
}