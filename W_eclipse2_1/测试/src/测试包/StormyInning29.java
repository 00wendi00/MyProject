/**
 * 文件名：StormyInning29.java
 * 项目-包：测试 - 测试包
 * 作者：张文迪
 * 创建日期：2014-10-12
 */
package 测试包;

/**
 * @author 张文迪
 * 类名：StormyInning29
 * 类说明：
 */
class BaseballException extends RuntimeException {}
class Foul extends RuntimeException {}
class Strike extends RuntimeException {}

abstract class Inning {
	public Inning() {}
	public void event() {}
	public abstract void atBat();
	public void walk() {} 
}

class StormException extends RuntimeException {}
class RainedOut extends RuntimeException {}
class PopFoul extends RuntimeException {}

interface Storm {
	public void event();
	public void rainHard();
}

public class StormyInning29 extends Inning implements Storm {
	public StormyInning29() {}
	public StormyInning29(String s) {}
	public void walk() {}  // ok!
	public void event() {}  //  ok!
	public void rainHard() {}
	public void atBat() {System.out.println("额 ！！！");}
	public static void main(String[] args) {
		StormyInning29 si = new StormyInning29();
		si.atBat();
		// What happens if you upcast?
		Inning i = new StormyInning29();
		i.atBat();		
	}
}
