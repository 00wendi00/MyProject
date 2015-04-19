/**
 * 文件名：BinaryFile.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-2
 */
package 第十八章IO系统;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 张文迪
 * 类名：BinaryFile
 * 类说明：字(Byte)节是长度单位。位（bit)也是长度单位。
		因为计算机通信和存储的时候都是以010101这样的二进制数据为基础的，这儿的一个0和1占的地方就叫bit(位),即一个二进制位。
		1Byte=8bit
		1KB=1024B
 * 
 */
public class BinaryFile
{
	public static byte[] read(File bfile) throws IOException
	{
		BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bfile));
		try
		{
			byte[] data = new byte[bf.available()];//返回可以从此输入流读取（或跳过）、且不受此输入流接下来的方法调用阻塞的估计字节数
			bf.read(data); //从此输入流中将 byte.length 个字节的数据读入一个 byte 数组中
			return data;  // 即 读入到data 里面~~
		}
		finally
		{
			bf.close();
		}
	}
	public static byte[] read(String bFile) throws IOException
	{
		return read(new File(bFile).getAbsoluteFile());
	}
}
