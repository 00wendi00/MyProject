package haha;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

public class Regist 
{
	public static ArrayList<Socket> socketList = new ArrayList<Socket>();
	public static void main(String args[]) throws IOException, SQLException
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
