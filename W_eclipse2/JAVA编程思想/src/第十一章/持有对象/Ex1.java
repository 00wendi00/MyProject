/**
 * 文件名：Ex1.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-9-29
 */
package 第十一章.持有对象;

import java.util.ArrayList;


/**
 * @author 张文迪
 * 类名：Ex1
 * 类说明：
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
		return id +" 跳~~~~~~" ;
	}	
	public String toString()
	{
		return id +" 跳!!!!!!!!!!" ;
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
