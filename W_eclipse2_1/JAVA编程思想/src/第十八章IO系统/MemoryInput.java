/**
 * 文件名：MemoryInput.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author 张文迪
 * 类名：MemoryInput
 * 类说明：  read() 读取单个字符。读取的字符，如果已到达流的末尾，则返回 -1 
 */
public class MemoryInput
{
	public static void main(String args[]) throws IOException
	{
		StringReader in  = new StringReader(BufferedInputFile.read("C:/Users/张文迪/Desktop/新建文件夹1/1.java"));
		int c;
		while((c = in.read()) != -1)    
			System.out.print((char)c);
	}
}
