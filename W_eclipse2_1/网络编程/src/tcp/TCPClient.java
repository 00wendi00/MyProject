/**
 * �ļ�����TCPClient.java
 * ��Ŀ-���������� - tcp
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-15
 */
package tcp;

/**
 * @author ���ĵ�
 * ������TCPClient
 * ��˵����
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
		
		String string = inputStream.readUTF();  //����ʽ����
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