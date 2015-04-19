/**
 * 文件名：TCPServer.java
 * 项目-包：网络编程 - tcp
 * 作者：张文迪
 * 创建日期：2014-6-15
 */
package tcp;

/**
 * @author 张文迪
 * 类名：TCPServer
 * 类说明：
 */


import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket svrSocket = new ServerSocket(6688);
	    Socket socket = svrSocket.accept(); //阻塞式方法
	    
	    OutputStream out = socket.getOutputStream();
	    DataOutputStream outputStream = new DataOutputStream(out);
	    //BufferedOutputStream bufStream = new BufferedOutputStream(outputStream);
	    
	    outputStream.writeUTF("hello!!");
	    outputStream.flush();
	    outputStream.close();
	    
	    socket.close();
	    //svrSocket.close();
	}
}