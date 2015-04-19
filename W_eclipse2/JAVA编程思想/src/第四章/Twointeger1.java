/**
 * 文件名：Twointeger1.java
 * 项目-包：JAVA编程思想 - 第四章
 * 作者：张文迪
 * 创建日期：2014-9-4
 */
package 第四章;

/**
 * @author 张文迪
 * 类名：Twointeger1
 * 类说明：练习5????????????????三元操作符     //输出 2进制，8进制 ，16进制 数？？？？？？？？  //int 型转化为String型  --- 3种方法
 */
public class Twointeger1
{
	public static void main(String args[])
    {
    	int m=0x10101010;
    	int n=0x101010;
    	System.out.println(m);
    	System.out.println(n);
    	System.out.println();
    	
    	System.out.println(String.valueOf(m));//转化为String  
    	System.out.println(m+"");//转化为String 
    	System.out.println(Integer.toString(m));//转化为String 
    	System.out.println();
    	    	
    	System.out.println();
    	
    	System.out.println(m+n);
    	System.out.println(Integer.toBinaryString(m));
    	System.out.println(Integer.toBinaryString(n));
    	System.out.println();
    	System.out.println(Integer.toBinaryString(m&n));
    	System.out.println(Integer.toBinaryString(m|n));
    	System.out.println(Integer.toBinaryString(m^n));
    	System.out.println(Integer.toBinaryString(m&=n));
    	System.out.println(Integer.toBinaryString(m|=n));
    	System.out.println(Integer.toBinaryString(m^=n));
    	System.out.println();
    	
    	
    	
    	it k = 0x1010101;
    	int j = 0x101010;
    	
    	
    	
    }
}
