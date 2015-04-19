/**
 * 文件名：Client_TCPTest.java
 * 项目-包：网络编程 - code2
 * 作者：张文迪
 * 创建日期：2014-6-15
 */
package code2;

/**
 * @author 张文迪
 * 类名：Client_TCPTest
 * 类说明：
 */

//Server_TCPTest.java
import java.io.*;
import java.net.*;

public class Client_TCPTest
{
	private Socket clientSk = null;// 服务器与客户端通信用套接字
	
	private BufferedReader input = null; // 输入流，来自客户端
	private PrintWriter output = null; // 输出流，指向客户端
	
	public Client_TCPTest(int port)
	{
		try
		{
			clientSk = new Socket("127.0.0.1", port); // 127.0.0.1 指本机
			
			input = new BufferedReader(new InputStreamReader(
					clientSk.getInputStream())); // 获得输入流
			output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					clientSk.getOutputStream())), true); // 获得输出流
			
			if (input != null && output != null) // 流建立成功
			{
				System.out.println("与服务器连接成功！");
				sendResponse("OK");
			}
			else 
			{
				System.out.println("与服务器连接失败！");
			}
			
			//sendResponse("From Server :Welcome......");
			getRequest();
		}
		catch (IOException e)
		{
			System.out.println("错误：" + e.getMessage());
		}
		finally
		{
			try
			{
				output.close();
				input.close();
				clientSk.close();
			}
			catch (Exception e)
			{
				// TODO: handle exception
			}
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
	
	//public static void main(String[] args) throws IOException
	//{
	//	Client_TCPTest sa = new Client_TCPTest(8000);
		// sa.getRequest();
	//}
}
