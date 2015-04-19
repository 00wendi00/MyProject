/**
 * 文件名：Long.java
 * 项目-包：JAVA编程思想 - 第三章
 * 作者：张文迪
 * 创建日期：2014-9-3
 */
package 第三章;

/**
 * @author 张文迪
 * 类名：Long
 * 类说明：练习8：   没有为类型 Long 定义方法 toBinaryString（long）
 */
public class Long
{
    public static void main(String args[])
    {
    	long n1 = 0xfffff;
    	long n2 = 0132654564;
    	System.out.println("n1 "+Long.toBinaryString(n1));
    	System.out.println("n2 "+Long.toBinaryString(n2));
    }
}
