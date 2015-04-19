/**
 * 文件名：LostMessage18.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：LostMessage18
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

class MeaninglessException extends Exception {
	public String toString() {
		return "A meaningless exception";
	}
}	

public class LostMessage18 {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}
	void dispose() throws HoHumException {
		throw new HoHumException();
	}
	void eliminate() throws MeaninglessException {
		throw new MeaninglessException();
	}
	public static void main(String[] args) {
		try 
		{
			LostMessage18 lm = new LostMessage18();
			try 
			{
				try 
				{
					lm.f();
					lm.dispose();
				} 
				finally
				{
					lm.eliminate();
				}
			} 
			catch(Exception e) 
			{
				System.out.println(e);
			}
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
}