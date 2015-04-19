/**
 * 文件名：SprinklerSystem1.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-13
 */
package 第十三章字符串;

/**
 * @author 张文迪
 * 类名：SprinklerSystem1
 * 类说明：
 */
class WaterSource 
{
	private String s;
	WaterSource() 
	{
		System.out.println("WaterSource()");
		s = "Constructed";
	}
	public String toString() { return s; }
}

public class SprinklerSystem1 
{
	private String valve1, valve2, valve3, valve4;	
	private WaterSource source = new WaterSource();
	private int i;
	private float f;
	// appears to create only one StringBuilder: (using javap -c)
	public String toString() 
	{
		return
			"valve1 = " + valve1 + " " + 
			"valve2 = " + valve2 + " " +
			"valve3 = " + valve3 + " " +
			"valve4 = " + valve4 + " " +
			"i = " + i + " " + "f = " + f + " " +
			"source = " + source;
	}
	public static void main(String args[]) 
	{
		SprinklerSystem1 sprinklers = new SprinklerSystem1();
		System.out.println(sprinklers);
	}
}
