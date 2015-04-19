/**
 * 文件名：Ex23.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-2
 */
package 第十八章IO系统;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.BitSet;

/**
 * @author 张文迪
 * 类名：Ex23
 * 类说明：     CharBuffer~~~~~~~~醉！！~~~~~~   此类实现 CharSequence 接口，以便字符缓冲区可以用于任何接受字符序列的地方  
 */
public class Ex23 
{
	static BitSet isPrintable = new BitSet(127);   //此类实现了一个按需增长的位向量
	static String encoding = System.getProperty("file.encoding");   //获取指定键指示的系统属性
	static 
	{
		// Assume an encoding that obeys ASCII eg.ISO-8859-1.
		// Characters 32 to 127 represent printable characters.
		for(int i = 32; i <= 127; i++)
			isPrintable.set(i);
	}
	// Set the position to the last printable character
	public static void setPrintableLimit(CharBuffer cb) 
	{
		cb.rewind();//重绕此缓冲区。将位置设置为 0 并丢弃标记。 
				   //在一系列通道写入或获取 操作之前调用此方法（假定已经适当设置了限制）。
		while(isPrintable.get(cb.get()));
		cb.limit(cb.position() - 1);
		cb.rewind();
	}
	public static void main(String[] args) 
	{
		System.out.println("Default Encoding is: " + encoding);
		CharBuffer buffer = ByteBuffer.allocate(16).asCharBuffer();
		buffer.put("ABCDE" + (char) 0x01 + "FG");
		buffer.rewind();
		System.out.println(buffer); // Print everything
		setPrintableLimit(buffer);
		System.out.println(buffer); // Print printable
	}
}