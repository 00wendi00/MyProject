/**
 * �ļ�����MyWebServer.java
 * ��Ŀ-���������� - code2
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-15
 */
package code2;

/**
 * @author ���ĵ�
 * ������MyWebServer
 * ��˵����
 */


import java.net.*;
import java.io.*;

public class MyWebServer
{
	public static void main(String[] args) //throws Exception
	{
		try
		{
			ServerSocket svrSocket = new ServerSocket(8888);  //��������
			System.out.println("������������������ʼ������������..........");
			
			Socket socket = svrSocket.accept(); //����ʽ����
			System.out.println("���ӳɹ�..........");
			
			OutputStream out = socket.getOutputStream();
			//BufferedReader br = new BufferedReader(new FileReader("D:\\index.html"));
			
			URL url = new URL("http://www.163.com");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String buf=null;
			
			while((buf=br.readLine())!=null)
			{
				out.write(buf.getBytes());
				//System.out.println(buf);
			}
			
		    br.close();
		    out.close();
			socket.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //svrSocket.close();
	}
}