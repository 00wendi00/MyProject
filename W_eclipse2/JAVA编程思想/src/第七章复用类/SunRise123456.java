/**
 * 文件名：SunRise123456.java
 * 项目-包：JAVA编程思想 - 第七章复用类
 * 作者：张文迪
 * 创建日期：2014-9-8
 */
package 第七章复用类;

/**
 * @author 张文迪
 * 类名：SunRise123456
 * 类说明：练习13.  重载
 */
public class SunRise123456 extends Sun123456
{
     public static void main(String args[])
     {
    	 SunRise123456 sunRise123456 = new SunRise123456();
    	 sunRise123456.Time123456(2f);
    	 sunRise123456.Time123456(3.0321);
    	 sunRise123456.Time123456('8');
    	 sunRise123456.Time123456(0000,3.0);
     }
     void Time123456(float f)
     {
    	 System.out.println("Time123465(float) = "+f);
     }
     void Time123456(double d)
     {
    	 System.out.println("Time123465(double) = "+d);
     }
     void Time123456(char c)
     {
    	 System.out.println("Time123465(char) = "+c);
     }
     void Time123456(int i,double d)
     {
    	 System.out.println("Time123465(int+double) = "+i+" + "+d);
     }
}

class Sun123456
{
	void Time123456(int i)
	{
		System.out.println("Time123465(int) = "+i);
	}
}
