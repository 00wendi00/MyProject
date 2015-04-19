/**
 * 文件名：Test1231.java
 * 项目-包：JAVA编程思想 - 第二十一章并发
 * 作者：张文迪
 * 创建日期：2014-11-7
 */
package 第二十一章并发;

import java.text.NumberFormat;
import java.util.Random;

/**
 * @author 张文迪
 * 类名：Test1231
 * 类说明：模仿掷 100000000 次硬币~~~ 查看结果： 百分号输出·~~~
 */
public class Test1231
{
	public static void main(String args[])
	{
		Random rand = new Random();
		int i = 0;
		int k = 0;
		for(int m = 0;m<100000000;m++)
		{
			i += rand.nextInt(2);
			k += rand.nextInt(2);
		}
		double d = (double)i/(double)k;
		 NumberFormat nt = NumberFormat.getPercentInstance(); //返回当前默认语言环境的百分比格式。 
		 	//NumberFormat  是所有数值格式的抽象基类
		 nt.setMinimumFractionDigits(5);
		System.out.println(i);
		System.out.println(k);
		System.out.println(nt.format(d));
	}
}
