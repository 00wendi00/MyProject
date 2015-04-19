/**
 * 文件名：TCPClient.java
 * 项目-包：网络编程 - tcp
 * 作者：张文迪
 * 创建日期：2014-6-15
 */
package tcp;

/**
 * @author 张文迪
 * 类名：TCPClient
 * 类说明：
 */

import java.net.*;
import java.io.*;

public class TCPClient
{
	public static void main(String[] args) throws Exception
	{
		Socket socket = new Socket("127.0.0.1", 6688);
		
		InputStream in = socket.getInputStream();
		DataInputStream inputStream = new DataInputStream(in);
		//BufferedInputStream bufStream = new BufferedInputStream(inputStream);
		
		String string = inputStream.readUTF();  //阻塞式方法
		System.out.println(""+string);
		
		inputStream.close();
		socket.close();
		
		//OutputStream os = s.getOutputStream();
		//DataOutputStream dos = new DataOutputStream(os);
		//Thread.sleep(30000);
		//dos.writeUTF("hello server!");
		//dos.flush();
		//dos.close();
		//s.close();
	}
}