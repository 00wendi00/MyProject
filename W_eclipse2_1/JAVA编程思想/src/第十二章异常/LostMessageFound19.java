/**
 * 文件名：LostMessageFound19.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：LostMessageFound19
 * 类说明：
 */
class VeryImportantException extends Exception {
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException extends Exception {
	public String toString() {
		return "A trivial exception";
	}
}

public class LostMessageFound19 {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}
	void dispose() throws HoHumException {
		throw new HoHumException();
	}
	public static void main(String[] args) {
		try {
			LostMessageFound19 lmf = new LostMessageFound19();
			try 
			{
				lmf.f();
			}
			catch(Exception e) 
			{
				System.out.println(e);
			} 
			finally 
			{
				lmf.dispose();
			}

		} catch(Exception e) {
			System.out.println(e);
		}
	}
}