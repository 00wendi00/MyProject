/**
 * 文件名：NonCollectionSequence.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-10
 */
package 第十一章.持有对象;

import java.util.*;


import typeinfo.pets.Pet;
import typeinfo.pets.Pets;


/**
 * @author 张文迪
 * 类名：NonCollectionSequence
 * 类说明：
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
