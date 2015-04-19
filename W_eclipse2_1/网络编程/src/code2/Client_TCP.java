/**
 * 文件名：Client_TCP.java
 * 项目-包：网络编程 - code2
 * 作者：张文迪
 * 创建日期：2014-6-15
 */
package code2;

/**
 * @author 张文迪
 * 类名：Client_TCP
 * 类说明：
 */

//Client_TCP.java
import java.io.*;
import java.net.*;


public class Client_TCP
{// 本程序是一个简单的客户端，用来和服务器连接
	public static void main(String[] arges)
	{
		try
		{
			//InetAddress addr = InetAddress.getByName(null);// 获取一个IP。null表示本机
			Socket sk = new Socket("127.0.0.1", 8000);// 打开8000端口，与服务器建立连接
			//DataInputStream input = null; // 输入流，来自服务器端
			//PrintStream output = new PrintStream(sk.getOutputStream());
			DataOutputStream output = null; // 输出流，指向服务器端
			//input = new DataInputStream(sk.getInputStream()); // 获得输入流
			output = new DataOutputStream(sk.getOutputStream()); // 获得输出流
			//System.out.println(input.readUTF());// 接收服务器信息
			//output.writeUTF("From Client: Hello....");// 向服务器发送信息
			output.writeUTF("Hello....");
			output.flush();
			output.close();
			sk.close();
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
