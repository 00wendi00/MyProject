/**
 * 文件名：Ex10.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：Ex10
 * 类说明：
 */
class GException extends Exception {
	GException(String s) { super(s); }
}

class HException extends Exception {
	HException(String s) { super(s); }
}

public class Ex10 {
	static void f() {
		try {
			try {
				g();
			} catch(GException ge) {
				System.out.println("Caught GException in f() inner try");
				ge.printStackTrace();
				throw new HException("from f(), inner try~~~~~~~~~~");
			}
		} catch(HException he) {
			System.out.println("Caught HException in f() outer try");
			he.printStackTrace(System.out);
		}
	}
	static void g() throws GException {
		throw new GException("from g()");
	}
	public static void main(String[] args) 
	{
		f();
	}	
}

