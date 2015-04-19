/**
 * 文件名：Ex16.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author 张文迪
 * 类名：Ex16
 * 类说明：
 */
public class Ex16
{
	static String file = "C:/Users/张文迪/Desktop/新建文件夹1/2.txt";
	static void display() throws IOException
	{
		RandomAccessFile rf = new RandomAccessFile(file, "r");
		System.out.println(rf.readByte());    
		System.out.println(rf.readShort());
		System.out.println(rf.readChar());
		System.out.println(rf.readInt());
		System.out.println(rf.readLong());
		System.out.println(rf.readFloat());
		System.out.println(rf.readDouble());
		System.out.println(rf.readBoolean());
		System.out.println(rf.readUTF());
		rf.close();
	}
	public static void main(String args[]) throws IOException
	{
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		rf.writeByte('-');
		rf.writeShort(21);
		rf.writeChar('w');
		rf.writeInt(3);
		rf.writeLong(1231);
		rf.writeFloat(213f);
		rf.writeDouble(25152d);
		rf.writeBoolean(true);
		rf.writeUTF("哈哈");
		rf.close();
		display();
		System.out.println("~~~~~~~~~~~");
		
		rf = new RandomAccessFile(file, "rw");    //恩 ！ 这个精髓~ 
		rf.seek(3); // 1 boolean + 2 bytes
		rf.writeChar('B');
		rf.close();
		display();
	}
}
