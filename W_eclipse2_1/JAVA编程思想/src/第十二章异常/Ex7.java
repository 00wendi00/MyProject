/**
 * �ļ�����Ex7.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����쳣
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-11
 */
package ��ʮ�����쳣;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author ���ĵ�
 * ������Ex7
 * ��˵����
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
