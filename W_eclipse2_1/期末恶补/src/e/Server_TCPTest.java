/**
 * 文件名：Server_TCPTest.java
 * 项目-包：期末恶补 - e
 * 作者：张文迪
 * 创建日期：2014-6-26
 */
package e;

/**
 * @author 张文迪
 * 类名：Server_TCPTest
 * 类说明：
 */

//Server_TCPTest.java
import java.io.*;
import java.net.*;

public class Server_TCPTest
{
	ServerSocket svrSkt = null;// 服务器套接字
	Socket cltSkt = null;// 服务器与客户端通信用套接字
	
	private BufferedReader input = null; // 输入流，来自客户端
	private PrintWriter output = null; // 输出流，指向客户端
	
	public Server_TCPTest(int port)
	{
		System.out.println("服务器代理正在监听，端口：" + port + "等待客户连接......");
		try
		{
			svrSkt = new ServerSocket(port); // 开始监听
			
			while (true) // 保持循环监听
			{
				cltSkt = svrSkt.accept(); // 接收连接请求
				
				input = new BufferedReader(new InputStreamReader(
						cltSkt.getInputStream())); // 获得输入流
				output = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(cltSkt.getOutputStream())), true); // 获得输出流
				
				if (input != null && output != null) // 流建立成功
				{
					// System.out.println("客户端连接成功！");
					while (true)
					{
						String str = getRequest();
						if (str.equals("OK"))
						{
							sendResponse("服务器信息为:"
									+ InetAddress.getLocalHost().getHostName());
						}
						else if (str.equals("bye"))
						{
							try
							{
								output.close();
								input.close();
								cltSkt.close();
								break;
							}
							catch (Exception e)
							{
								// TODO: handle exception
							}
						}
					}
				}
				
				// sendResponse("From Server :Welcome......");
			}
			// output.println("From Server :Welcome......");
		}
		catch (IOException e)
		{
			System.out.println("错误：" + e.getMessage());
		}
		finally
		{
			// svrSkt.close();
		}
	}
	
	public String getRequest()
	{// 获取从客户端发送的信息
		String frmClt = null;
		try
		{
			frmClt = input.readLine();
			System.out.println(frmClt);
		}
		catch (Exception e)
		{
			System.out.println("无法读取端口.....");
			System.exit(0);
		}
		return frmClt;
	}
	
	public void sendResponse(String message)
	{// 向客户端发送信息
		try
		{
			output.println(message);
			output.flush();// 把当前缓冲区中的输出流全部刷到通信管道中。
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		Server_TCPTest sa = new Server_TCPTest(8000);
		// sa.getRequest();
	}
}
