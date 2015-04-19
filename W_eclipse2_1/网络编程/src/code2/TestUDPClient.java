/**
 * 文件名：TestUDPClient.java
 * 项目-包：网络编程 - code2
 * 作者：张文迪
 * 创建日期：2014-6-15
 */
package code2;

/**
 * @author 张文迪
 * 类名：TestUDPClient
 * 类说明：
 */


import java.net.*;
import java.io.*;

public class TestUDPClient
{
	public static void main(String args[]) throws Exception
	{
		/*
		long n = 10000L;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  //数组由系统自动创建
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeLong(n);

		byte[] buf = baos.toByteArray();//拿到那个自动分配的字节数组。
		*/
		byte[] buf = new String("hello!").getBytes();

		System.out.println(buf.length);

		DatagramPacket dp = new DatagramPacket(buf, buf.length,
				new InetSocketAddress("127.0.0.1", 5678));  //InetSocketAddress对象代表网络上的地址。
		DatagramSocket ds = new DatagramSocket(9999);  //这个进程利用9999端口向5678端口发送包。
		
		while(true)
		{
		    ds.send(dp);  //发出数据包
		    Thread.sleep(100);
		}
		
		//ds.close();
	}
}