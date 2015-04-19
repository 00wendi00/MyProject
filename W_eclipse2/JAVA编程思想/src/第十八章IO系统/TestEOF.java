/**
 * 文件名：TestEOF.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 张文迪
 * 类名：TestEOF
 * 类说明：
 */
public class TestEOF
{
	public static void mian(String args[]) throws IOException
	{
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(new FileInputStream("C:/Users/张文迪/Desktop/新建文件夹1/1.java")));
		while(in.available() != 0)   //可以不受阻塞地从此输入流中读取（或跳过）的估计字节数
			System.out.println((char)in.readByte());
	}
}
