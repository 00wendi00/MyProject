/**
 * 文件名：Ex4.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第九章
 * 作者：张文迪
 * 创建日期：2014-9-15
 */
package cn.edu.hainu.第九章;

/**
 * @author 张文迪
 * 类名：Ex4  
 * 类说明：    练习4： 注意静态方法
 */

abstract class Dad {
}

class Son extends Dad {
	protected void print() { System.out.println("Son"); }
}

abstract class SecondDad {
	abstract protected void print();
}

class SecondSon extends SecondDad {
	protected void print() { System.out.println("SecondSon"); }
}

public class Ex4 {
	public static void testPrint(Dad d) {
		((Son)d).print();
	}
	public static void secondTestPrint(SecondDad sd) {
		sd.print();
	}
	public static void main(String[] args) {
		Son s = new Son();
		Ex4.testPrint(s);
		SecondSon ss = new SecondSon();
		Ex4.secondTestPrint(ss);			
	}
}