/**
 * 文件名：Server_TCP.java
 * 项目-包：网络编程 - code2
 * 作者：张文迪
 * 创建日期：2014-6-15
 */
package code2;

/**
 * @author 张文迪
 * 类名：Server_TCP
 * 类说明：
 */

//Server_TCP.java
import java.io.*;
import java.net.*;

public class Server_TCP
{
	ServerSocket svrSkt = null;// 服务器套接字
	Socket cltSkt = null;// 客户端套接字
	DataInputStream input = null; // 输入流，来自客户端
	PrintStream output = null; // 输出流，指向客户端

	public Server_TCP(int port)
	{
		System.out.println("服务器正在监听，端口：" + port);
		try
		{
			svrSkt = new ServerSocket(port); // 开始监听
		} catch (IOException e)
		{
			System.out.println("监听端口" + port + "失败");
		}
		try
		{
			cltSkt = svrSkt.accept(); //侦听并接受到此套接字的连接请求。此方法在连接传入之前一直阻塞。
		} catch (IOException e)
		{
			System.out.println("连接失败");
		}
		try
		{
			input = new DataInputStream(cltSkt.getInputStream()); // 获得输入流
			output = new PrintStream(cltSkt.getOutputStream()); // 获得输出流
			
			if(input==null||output==null)
				System.out.println("error!");
			
			//String str = null;
			//str = input.readUTF();
			//System.out.println(str);
		} catch (IOException e)
		{
		}
		//output.println("From Server :Welcome......");
	}

	public String getRequest()
	{// 获取从客户端接收的信息
		String frmClt = null;
		try
		{
			frmClt = input.readUTF();
			System.out.println(frmClt);
		} catch (Exception e)
		{
			//System.out.println("无法读取端口.....");
			//System.exit(0);
			e.printStackTrace();
		}
		return frmClt;
	}

	public void sendResponse(String message)
	{// 向客户端发送信息
		try
		{
			output.println(message);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException
	{
		Server_TCP sa = new Server_TCP(8000);
		sa.getRequest();
	}
}
