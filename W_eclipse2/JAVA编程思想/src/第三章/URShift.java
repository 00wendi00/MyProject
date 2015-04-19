/**
 * 文件名：URShift.java
 * 项目-包：JAVA编程思想 - 第三章
 * 作者：张文迪
 * 创建日期：2014-9-3
 */
package 第三章;

import 第一二章.Print;

/**
 * @author 张文迪
 * 类名：URShift
 * 类说明：移位操作符
 */
public class URShift
{
    public static void main(String args[])
    {
    	int i = -1;
    	System.out.println(~i);
    	System.out.println(i);
    	System.out.println(Integer.toBinaryString(i));
    	i>>>= 10;
    	System.out.println(i);
    	System.out.println(Integer.toBinaryString(i));
    	System.out.println();
    	
    	byte b=-1;
    	System.out.println(Integer.toBinaryString(b));
    	b >>>= 10;
    	System.out.println(b);
    	System.out.println(Integer.toBinaryString(b));
    	System.out.println(Integer.toBinaryString(b>>>10));   	    	   	   	

    	
    }
}



