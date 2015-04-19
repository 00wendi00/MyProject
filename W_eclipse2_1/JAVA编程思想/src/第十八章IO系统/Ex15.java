/**
 * 文件名：Ex15.java
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

/**
 * @author 张文迪
 * 类名：Ex15
 * 类说明：
 */
public class Ex15
{
	public static void main(String args[]) throws IOException
	{
		DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("C:/Users/张文迪/Desktop/新建文件夹1/2.txt")));													
		out.writeByte('-');
		out.writeShort(21);
		out.writeChar('w');
		out.writeInt(3);
		out.writeLong(1231);
		out.writeFloat(213f);
		out.writeDouble(25152d);
		out.writeBoolean(true);
		out.writeUTF("哈哈");
		out.close();
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(new FileInputStream("C:/Users/张文迪/Desktop/新建文件夹1/2.txt")));
		
		//System.out.println(in.read());
		
		System.out.println(in.readByte());    //    - 号占多少个字节~~
		System.out.println(in.readShort());
		System.out.println(in.readChar());
		System.out.println(in.readInt());
		System.out.println(in.readLong());
		System.out.println(in.readFloat());
		System.out.println(in.readDouble());
		System.out.println(in.readBoolean());
		System.out.println(in.readUTF());
	}
}
