/**
 * 文件名：SimpleCollection.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-9-29
 */
package 第十一章.持有对象;

import java.util.*;


/**
 * @author 张文迪
 * 类名：SimpleCollection
 * 类说明： 练习2
 */
public class SimpleCollection
{
    public static void main(String args[])
    {
    	//Collection<Integer> q = new ArrayList<Integer>();
    	Set<Integer> c = new HashSet<Integer>();
    	for(int i = 0;i<8;i++)
    		c.add(i);
    	for(Integer i : c)
    		System.out.print(i+", ");
    }
}
