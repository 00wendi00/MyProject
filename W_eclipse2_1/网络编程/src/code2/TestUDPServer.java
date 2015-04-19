/**
 * 文件名：TestUDPServer.java
 * 项目-包：网络编程 - code2
 * 作者：张文迪
 * 创建日期：2014-6-15
 */
package code2;

/**
 * @author 张文迪
 * 类名：TestUDPServer
 * 类说明：
 */


import java.net.*;
import java.io.*;

public class TestUDPServer
{
	public static void main(String args[]) throws Exception
	{
		byte buf[] = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length); //new一个包裹，包裹里的buf才是UDP接受数据的容器。 
		DatagramSocket ds = new DatagramSocket(5678);
		while (true)
		{
			ds.receive(dp);   //开始接收，阻塞式的方法。
			//ByteArrayInputStream bais = new ByteArrayInputStream(buf);
			//DataInputStream dis = new DataInputStream(bais);
			//System.out.println(dis.readLong());  //把8个字节转换为long类型。
			System.out.println(new String(buf));
		}
	}
}