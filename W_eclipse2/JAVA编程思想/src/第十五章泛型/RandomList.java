/**
 * 文件名：RandomList.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-20
 */
package 第十五章泛型;

import java.util.ArrayList;
import java.util.Random;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;


/**
 * @author 张文迪
 * 类名：RandomList
 * 类说明：
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
		for(String s : "莫斯科郊外的晚上!~！".split(""))
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
