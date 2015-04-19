/**
 * 文件名：InfiniteRecursion.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-14
 */
package 第十三章字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张文迪
 * 类名：InfiniteRecursion
 * 类说明： 练习2 ~ ~ 
 */
public class InfiniteRecursion
{
    public String toString()
    {
    	return "InfiniteRecursion address:" + super.toString() + "\n"; // 用this 就会无意识递归~无限循环
    }
    public static void main(String args[])
    {
    	List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
    	for(int i = 0;i< 10;i++)
    		v.add(new InfiniteRecursion());
    	System.out.println(v);
    }
}
