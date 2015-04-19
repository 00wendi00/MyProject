/**
 * �ļ�����RandomList.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���·���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-20
 */
package ��ʮ���·���;

import java.util.ArrayList;
import java.util.Random;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;


/**
 * @author ���ĵ�
 * ������RandomList
 * ��˵����
 */
public class RandomList<T>
{
	private ArrayList<T> storage = new ArrayList<T>();
	private Random random = new Random(47);
	public void add(T item) {storage.add(item);}
	public T select()
	{
		return storage.get(random.nextInt(storage.size()));
	}
	public static void main(String rags[])
	{
		RandomList<String> rs = new RandomList<String>();
		for(String s : "Ī˹�ƽ��������!~��".split(""))
			rs.add(s);
		for(int i = 0;i<11;i++)
			System.out.print(rs.select()+" ");
		System.out.println();
		
		RandomList<Object> ri = new RandomList<Object>();			
		for(int p = 0;p<5;p++)			
			ri.add(p);
		for(int k= 0;k<5;k++)
			System.out.print(ri.select());
		System.out.println();
		
		RandomList<Pet> rp = new RandomList<Pet>();
		for(Pet p : Pets.arrayList(10))
			rp.add(p);
		for(int i = 0; i < 11; i++)
			System.out.print(rp.select() + " "); 
	}
}
