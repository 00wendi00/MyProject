/**
 * 文件名：Ex7.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author 张文迪
 * 类名：Ex7
 * 类说明：
 */
public class Ex7
{
	private static int[] ia = new int[2];	
	private static Logger logger = Logger.getLogger("Ex7 Exceptions");
	static void logException(Exception e) { // Exception e argument
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString()); 	
	}
	public static void main(String[] args) {
		try {
			ia[2] = 3;	
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println(
				"Caught ArrayIndexOutOfBoundsException");
			e.printStackTrace();
			// call logging method:
			System.out.println(
					);
			logException(e);
		} 
	}
}
