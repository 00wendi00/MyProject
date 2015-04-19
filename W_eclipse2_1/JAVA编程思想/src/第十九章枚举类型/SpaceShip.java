/**
 * 文件名：SpaceShip.java
 * 项目-包：JAVA编程思想 - 第十九章枚举类型
 * 作者：张文迪
 * 创建日期：2014-11-3
 */
package 第十九章枚举类型;

/**
 * @author 张文迪
 * 类名：SpaceShip
 * 类说明：  重写toString() 第一个字母大写~~~~~~~~~~~~~~ values()即是枚举对象~ 
 */
public enum SpaceShip
{
	SCOUT,HAHA,HAODE,NIMA,CAONIMA;
	public String toString()
	{
		String id = name();
		String lower = id.substring(1).toLowerCase();
		return id.charAt(0) +lower;
	}
	public static void main(String args[])
	{
		for(SpaceShip s:values())
			System.out.println(s);
	}
}
