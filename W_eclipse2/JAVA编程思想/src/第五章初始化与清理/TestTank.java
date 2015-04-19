/**
 * 文件名：TestTank.java
 * 项目-包：JAVA编程思想 - 第五章初始化与清理
 * 作者：张文迪
 * 创建日期：2014-9-5
 */
package 第五章初始化与清理;

/**
 * @author 张文迪
 * 类名：TestTank
 * 类说明：满状态和控状态？？？？？？内存？   练习12.
 */
public class TestTank
{
   public static void main(String args[])
   {
	   for(int k=0;k>=0;k++)
	   {
	   Tank tank = new Tank();
	   }
   }
}


class Tank
{
	 Tank()
	{
		System.out.println("tank");
	}
	protected void finalize()
	{
		System.out.println("清理了");
	}
}
