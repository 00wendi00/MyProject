/**
 * �ļ�����Server_TCPTest.java
 * ��Ŀ-������ĩ�� - e
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-26
 */
package e;

/**
 * @author ���ĵ�
 * ������Server_TCPTest
 * ��˵����
 */

//Server_TCPTest.java
import java.io.*;
import java.net.*;

public class Server_TCPTest
{
	ServerSocket svrSkt = null;// �������׽���
	Socket cltSkt = null;// ��������ͻ���ͨ�����׽���
	
	private BufferedReader input = null; // �����������Կͻ���
	private PrintWriter output = null; // �������ָ��ͻ���
	
	public Server_TCPTest(int port)
	{
		System.out.println("�������������ڼ������˿ڣ�" + port + "�ȴ��ͻ�����......");
		try
		{
			svrSkt = new ServerSocket(port); // ��ʼ����
			
			while (true) // ����ѭ������
			{
				cltSkt = svrSkt.accept(); // ������������
				
				input = new BufferedReader(new InputStreamReader(
						cltSkt.getInputStream())); // ���������
				output = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(cltSkt.getOutputStream())), true); // ��������
				
				if (input != null && output != null) // �������ɹ�
				{
					// System.out.println("�ͻ������ӳɹ���");
					while (true)
					{
						String str = getRequest();
						if (str.equals("OK"))
						{
							sendResponse("��������ϢΪ:"
									+ InetAddress.getLocalHost().getHostName());
						}
						else if (str.equals("bye"))
						{
							try
							{
								output.close();
								input.close();
								cltSkt.close();
								break;
							}
							catch (Exception e)
							{
								// TODO: handle exception
							}
						}
					}
				}
				
				// sendResponse("From Server :Welcome......");
			}
			// output.println("From Server :Welcome......");
		}
		catch (IOException e)
		{
			System.out.println("����" + e.getMessage());
		}
		finally
		{
			// svrSkt.close();
		}
	}
	
	public String getRequest()
	{// ��ȡ�ӿͻ��˷��͵���Ϣ
		String frmClt = null;
		try
		{
			frmClt = input.readLine();
			System.out.println(frmClt);
		}
		catch (Exception e)
		{
			System.out.println("�޷���ȡ�˿�.....");
			System.exit(0);
		}
		return frmClt;
	}
	
	public void sendResponse(String message)
	{// ��ͻ��˷�����Ϣ
		try
		{
			output.println(message);
			output.flush();// �ѵ�ǰ�������е������ȫ��ˢ��ͨ�Źܵ��С�
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		Server_TCPTest sa = new Server_TCPTest(8000);
		// sa.getRequest();
	}
}
