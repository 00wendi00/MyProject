/**
 * 文件名：Ex1.java
 * 项目-包：JAVA编程思想 - 第十九章枚举类型
 * 作者：张文迪
 * 创建日期：2014-11-3
 */
package 第十九章枚举类型;

/**
 * @author 张文迪
 * 类名：Ex1
 * 类说明：
 */

import static 第十九章枚举类型.Signal.*;
public class Ex1
{
	Signal color = Signal.RED;
	public void change()
	{
		switch(color)
		{
		   case RED: color = GREEN; break;
		   case GREEN : color = YELLOW;  break;
		   case YELLOW : color = RED;break;
		}
	}
	public String toString()
	{
		return color+" ";
	}
	public static void main(String args[])
	{
	     Ex1 e = new Ex1();
	     for(int i= 0;i<10;i++)
	     {	  	  
	    	 System.out.println(e);
	         e.change();
	     }
	}
}
