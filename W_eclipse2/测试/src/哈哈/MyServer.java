package 哈哈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer 
{
	public static ArrayList<Socket> socketList = new ArrayList<Socket>();
	public static void main(String args[]) throws IOException
	{
		ServerSocket ss = new ServerSocket(30000);
		while(true)
		{
			Socket s = ss.accept();
			socketList.add(s);
			new Thread(new ServerThread(s)).start();
		}
	}
}
class ServerThread implements Runnable
{
	Socket s = null;
	BufferedReader br = null;
	public ServerThread(Socket s) throws IOException
	{
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));
	}
	public void run()
	{
		try {
			String content = null;
			while((content = readFromClient()) != null)
			{
				for(Socket s : MyServer.socketList)
				{ 
					System.out.println("�յ�����Ϣ"+content+"�ٷ���ȥ");
					OutputStream os = s.getOutputStream();
					os.write((content+"�ַ�������~~"+"\n").getBytes("utf-8"));
				}
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private String readFromClient()
	{
		try {
			return br.readLine();
		} catch (IOException e) {
			MyServer.socketList.remove(s);
		}
		return null;
	}
}