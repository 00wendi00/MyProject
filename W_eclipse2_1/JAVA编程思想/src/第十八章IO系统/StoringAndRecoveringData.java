/**
 * 文件名：StoringAndRecoveringData.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

/**
 * @author 张文迪
 * 类名：StoringAndRecoveringData
 * 类说明：
 */
public class StoringAndRecoveringData
{
	public static void main(String args[]) throws IOException
	{
		DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("C:/Users/张文迪/Desktop/新建文件夹1/1.java")));
		             					//创建一个向具有指定名称的文件中写入数据的输出文件流
		out.writeDouble(3.14159);
		out.writeUTF("That was pi");
		out.writeDouble(1.41413);
		out.close();
		
		DataInputStream in  = new DataInputStream(
				new BufferedInputStream(new FileInputStream("C:/Users/张文迪/Desktop/新建文件夹1/1.java")));
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
	}
}
