/**
 * 文件名：AllTheColorsOfTheRainbow.java
 * 项目-包：JAVA编程思想 - 第一二章
 * 作者：张文迪
 * 创建日期：2014-9-3
 */
package 第一二章;

/**
 * @author 张文迪
 * 类名：AllTheColorsOfTheRainbow
 * 类说明：练习1,11. java默认初始化
 */
public class AllTheColorsOfTheRainbow
{
	
     int anIntegerRepresentingColors;
     void changTheHueOfTheColor(int newHue)
     {
    	 return;
     }
     public static void main(String args[])
     {
    	 AllTheColorsOfTheRainbow yellow = new AllTheColorsOfTheRainbow();
    	 yellow.changTheHueOfTheColor(7);
    	 System.out.println(yellow);
    	 System.out.println(yellow.anIntegerRepresentingColors);
     }
}
