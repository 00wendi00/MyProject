/**
 * 文件名：TestSockServer.java
 * 项目-包：网络编程 - tcp
 * 作者：张文迪
 * 创建日期：2014-6-15
 */
package tcp;

/**
 * @author 张文迪
 * 类名：TestSockServer
 * 类说明：
 */


import java.io.*;
import java.net.*;

public class TestSockServer
{
	public static void main(String[] args)
	{
		InputStream in = null;
		OutputStream out = null;
		try
		{
			ServerSocket ss = new ServerSocket(5888);
			Socket socket = ss.accept();
			in = socket.getInputStream();
			out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			DataInputStream dis = new DataInputStream(in);
			String s = null;
			if ((s = dis.readUTF()) != null)
			{
				System.out.println(s);
				System.out.println("from: " + socket.getInetAddress());
				System.out.println("Port: " + socket.getPort());
			}
			dos.writeUTF("hi，hello");
			dis.close();
			dos.close();
			socket.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
