/**
 * 文件名：BlueSky.java
 * 项目-包：内部类练习6 - 额3
 * 作者：张文迪
 * 创建日期：2014-9-25
 */
package 额3;

import 额1.World;
import 额2.Sky;

/**
 * @author 张文迪
 * 类名：BlueSky
 * 类说明：
 */
public class BlueSky extends Sky
{	
	public World haha111()
	{
		return this.new ColorSky();
	}
	public static void main(String args[])
	{
		BlueSky b = new BlueSky();
		World world = b.haha111();
		world.haha();
	}
}
