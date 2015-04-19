/**
 * 文件名：Twointeger.java
 * 项目-包：JAVA编程思想 - 第三章
 * 作者：张文迪
 * 创建日期：2014-9-3
 */
package 第三章;

/**
 * @author 张文迪
 * 类名：Twointeger
 * 类说明：3.10 按位操作符
 */
public class Twointeger
{
    public static void main(String args[])
    {
    	int m=0x10101010;
    	int n=0x101010;
    	System.out.println(m);
    	System.out.println(n);
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
    	
    }
}
