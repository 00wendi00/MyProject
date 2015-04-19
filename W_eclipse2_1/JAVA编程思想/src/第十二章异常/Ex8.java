/**
 * 文件名：Ex8.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：Ex8
 * 类说明：
 */
class Exception4 extends Exception {
	private String msg;
	Exception4(String msg) {
		super(msg);
		System.out.println("Exception4()");
		this.msg = msg;
	}
	protected void showS() { 
		System.out.println("Message from Exception4: " + msg);
	}
}

class Test8 {
	public static void f() throws Exception4 {
		System.out.println("f()");
		throw new Exception4("Ouch from f()");
	}
}

public class Ex8 {
	public static void main(String[] args) {
		try {
			Test8 t = new Test8();
			t.f();	
		} catch(Exception4 e) {
			System.err.println("Caught Exception4");
			e.printStackTrace();
			e.showS();
		} 
		//new Test8().f();   要有抛出声明~
	}	
}