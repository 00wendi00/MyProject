/**
 * 文件名：TestSockClient.java
 * 项目-包：网络编程 - tcp
 * 作者：张文迪
 * 创建日期：2014-6-15
 */
package tcp;

/**
 * @author 张文迪
 * 类名：TestSockClient
 * 类说明：
 */


import java.net.*;
import java.io.*;

public class TestSockClient
{
	public static void main(String[] args)
	{
		InputStream is = null;
		OutputStream os = null;
		try
		{
			Socket socket = new Socket("localhost", 5888);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF("hey");
			String s = null;
			if ((s = dis.readUTF()) != null)
				;
			System.out.println(s+" "+socket.getPort()+" "+socket.getInetAddress());
			dos.close();
			dis.close();
			socket.close();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
