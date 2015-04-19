/**
 * 文件名：SweetShop7.java
 * 项目-包：JAVA编程思想 - 第十四章类型信息
 * 作者：张文迪
 * 创建日期：2014-10-18
 */
package 第十四章类型信息;

/**
 * @author 张文迪
 * 类名：SweetShop7
 * 类说明：
 */

import static net.mindview.util.Print.*;

class Candy {
	static { print("Loading Candy"); }
}

class Gum {
	static { print("Loading Gum"); } 
}

class Cookie {
	static { print("Loading Cookie"); }
}

public class SweetShop7 {
	public static void main(String[] args) 
	{
		if(args.length < 1)
		{
			System.out.println("Usage: sweetName");
			System.exit(0);
		}
		Class c = null;
		try 
		{
			c = Class.forName(args[0]);
			print("Enjoy your " + args[0]);
		} catch(ClassNotFoundException e) {
			print("Couldn't find " + args[0]);
		}
	}
}
