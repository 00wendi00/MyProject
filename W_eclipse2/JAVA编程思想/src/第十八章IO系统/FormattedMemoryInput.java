/**
 * 文件名：FormattedMemoryInput.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author 张文迪
 * 类名：FormattedMemoryInput
 * 类说明：
 */
public class FormattedMemoryInput
{
	public static void main(String args[]) throws IOException
	{
		try
		{
			//数据输入流允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型。应用程序可以使用数据输出流写入稍后由数据输入流读取的数据。 		
			DataInputStream in  = new DataInputStream(
					new ByteArrayInputStream(
							BufferedInputFile.read("C:/Users/张文迪/Desktop/新建文件夹1/1.java").getBytes()));
			  //ByteArrayInputStream(byte[] buf)
		     //创建一个 ByteArrayInputStream，使用 buf 作为其缓冲区数组。该缓冲区数组不是复制得到的。
		    //pos 的初始值是 0，count 的初始值是 buf 的长度。
			
			while(true)
				System.out.print((char)in.readByte());
		}                                 //从所包含的输入流中读取此操作需要的字节。  返回byte~~
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}
