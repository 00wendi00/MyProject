/**
 * 文件名：TestServer.java
 * 项目-包：网络编程 - tcp
 * 作者：张文迪
 * 创建日期：2014-6-15
 */
package tcp;

/**
 * @author 张文迪
 * 类名：TestServer
 * 类说明：
 */


/*	范例名称：简单的client/server程序
 * 	源文件名称：TestClient.java/TestServer.java
 *	要  点：
 *		1. Java Socket编程步骤
 *		2. Socket/ServerSocket类用法
 *		3. 通过Socket对象可以获取通信对方Socket的信息
 */
import java.net.*;
import java.io.*;

public class TestServer
{
	public static void main(String args[])
	{
		try
		{
			ServerSocket s = new ServerSocket(8888);
			while (true)
			{
				Socket s1 = s.accept();
				OutputStream os = s1.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF("Hello," + s1.getInetAddress().getHostAddress() + "port#"
						+ s1.getPort() + "  bye-bye!");
				dos.close();
				s1.close();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("程序运行出错:" + e);
		}
	}
}