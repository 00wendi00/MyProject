/**
 * 文件名：Ex8.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-1
 */
package 第十一章.持有对象;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 张文迪
 * 类名：Ex8
 * 类说明： 练习8： 迭代器。  Iterator
 */

public class Ex8
{
     public static void main(String args[])
     {
    	 ArrayList<Gerbil1> gerbils = new ArrayList<Gerbil1>();
    	 for(int i = 0;i<5;i++)
    		 gerbils.add(new Gerbil1());
    	 Iterator<Gerbil1> it = gerbils.iterator();
    	 while(it.hasNext())
    	 {
    		 Gerbil1 ge = it.next();
    		 
    	 } 
    	 System.out.println();
    	 System.out.println();
    	 for(Gerbil1 g : gerbils)
    		 System.out.println(g);
     }
}
