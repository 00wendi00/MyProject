/**
 * 文件名：UsingRandomAccessFile.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author 张文迪
 * 类名：UsingRandomAccessFile
 * 类说明："r" 以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。  
 *		"rw" 打开以便读取和写入。如果该文件尚不存在，则尝试创建该文件。  
 *		"rws" 打开以便读取和写入，对于 "rw"，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备。     ~~
 *		"rwd"   打开以便读取和写入，对于 "rw"，还要求对文件内容的每个更新都同步写入到底层存储设备。  
 *
 *  	seek(index)绝对的，  skip(index)是相对的~~
 */
public class UsingRandomAccessFile
{
	static String file = "C:/Users/张文迪/Desktop/新建文件夹1/2.txt";
	static void display() throws IOException
	{
		RandomAccessFile rf = new RandomAccessFile(file, "r");
		for(int i =0;i<7;i++)
			System.out.println(i+" : "+rf.readDouble());
		System.out.println(rf.readUTF());
		rf.close();
	}
	public static void main(String args[]) throws IOException
	{
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		for(int i = 0;i<7;i++)
			rf.writeDouble(i*1.414);
		rf.writeUTF("end  88!");
		rf.close();
		display();
		
		rf = new RandomAccessFile(file, "rw");
		rf.seek(5*8);      //5*8表示    第5 个数, 8字节长（double ）.
		rf.writeDouble(47.0001);
		rf.writeDouble(47.00012); // !!!!
		rf.close();
		display();
	}
}
