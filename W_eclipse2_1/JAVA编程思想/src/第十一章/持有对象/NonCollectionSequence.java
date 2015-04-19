/**
 * �ļ�����NonCollectionSequence.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-10
 */
package ��ʮһ��.���ж���;

import java.util.*;


import typeinfo.pets.Pet;
import typeinfo.pets.Pets;


/**
 * @author ���ĵ�
 * ������NonCollectionSequence
 * ��˵����
 */
class PetSequence
{
	protected Pet[] pets = Pets.createArray(8);
}
public class NonCollectionSequence extends PetSequence
{	
    public Iterable<Pet> reversed()
    {
    	return new Iterable<Pet>()
		{
			public Iterator<Pet> iterator()
			{
				return new Iterator<Pet>()
				{
					private int index = 0;
					public boolean hasNext()
					{
						return index < pets.length;
					}
					public Pet next()
					{
						return pets[index++];
					}
					public void remove()
					{
						
					}					
				};
			}
    		
		};
    }
    public Iterable<Pet> randomized()
    {
    	return new Iterable<Pet>()
		{
			public Iterator<Pet> iterator()
			{
				List<Pet> hahalist = new ArrayList<Pet>(Arrays.asList(pets));
				Collections.shuffle(hahalist,new Random(47));
				return hahalist.iterator();
			}
		};
    }
    public static void main(String args[])
    {
    	NonCollectionSequence no = new NonCollectionSequence();
    	for(Pet p : no.reversed())
    		System.out.print(p.id()+" "+p+" "); 
    	System.out.println();
    	System.out.println("~~~~~~~~~~");
    	
    	for(Pet p : no.randomized())
    		System.out.print(p.id()+" "+p+" "); 
    	System.out.println();
    }
}
