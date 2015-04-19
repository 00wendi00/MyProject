/**
 * �ļ�����TCPServer.java
 * ��Ŀ-���������� - tcp
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-15
 */
package tcp;

/**
 * @author ���ĵ�
 * ������TCPServer
 * ��˵����
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
	    Socket socket = svrSocket.accept(); //����ʽ����
	    
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