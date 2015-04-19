/**
 * 文件名：MyWebServer.java
 * 项目-包：网络编程 - code2
 * 作者：张文迪
 * 创建日期：2014-6-15
 */
package code2;

/**
 * @author 张文迪
 * 类名：MyWebServer
 * 类说明：
 */


import java.net.*;
import java.io.*;

public class MyWebServer
{
	public static void main(String[] args) //throws Exception
	{
		try
		{
			ServerSocket svrSocket = new ServerSocket(8888);  //创建插座
			System.out.println("服务器已启动，并开始接受连接请求..........");
			
			Socket socket = svrSocket.accept(); //阻塞式方法
			System.out.println("连接成功..........");
			
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