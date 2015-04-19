/**
 * 文件名：Ex5.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-14
 */
package 第十三章字符串;

import java.math.BigInteger;
import java.util.Formatter;

/**
 * @author 张文迪
 * 类名：Ex5
 * 类说明：练习 5 ~类型转换~
 */

public class Ex5 {
	public static void main(String[] args) {
		Formatter f = new Formatter(System.out);

		char u = 'a';
		System.out.println("char u = \'a\'");
		f.format("%-2s 哈哈  %-2S %-2c %-2C %-5b %-5B %-3h %-3H %% \n", u,u,u,u,u,u,u,u);
		
		int v = 121;
		System.out.println("int v = 121");
		f.format("%-4s%-4S%-4d%-4c%-4C%-5b%-5B%-4x%-4X%-4h%-4H%%\n", v,v,v,v,v,v,v,v,v,v,v);
		
		BigInteger w = new BigInteger("50000000000000");
		System.out.println("BigInteger w = 50000000000000");
		f.format("%-15s%-15S%-5b%-5B%-15x%-15X%-5h%-5H%%\n", w,w,w,w,w,w,w,w); 

		double x = 179.543;
		System.out.println("double x = 179.543");
		f.format("%-8s%-8S%-5b%-5B%-15f%-15e%-15E%-12h%-12H%%\n", x,x,x,x,x,x,x,x,x);
		
		Conversion y = new Conversion();
		System.out.println("Conversion y = new Conversion()");
		f.format("%-20s%-20S%-5b%-5B%-10h%-10H%%\n", y,y,y,y,y,y);

		boolean z = false;
		System.out.println("boolean z = false");
		f.format("%-7s%-7S%-7b%-7B%-7h%-7H%%\n", z,z,z,z,z,z);
	}
}
