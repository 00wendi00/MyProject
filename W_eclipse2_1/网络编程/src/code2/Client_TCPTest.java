/**
 * �ļ�����Client_TCPTest.java
 * ��Ŀ-���������� - code2
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-15
 */
package code2;

/**
 * @author ���ĵ�
 * ������Client_TCPTest
 * ��˵����
 */

//Server_TCPTest.java
import java.io.*;
import java.net.*;

public class Client_TCPTest
{
	private Socket clientSk = null;// ��������ͻ���ͨ�����׽���
	
	private BufferedReader input = null; // �����������Կͻ���
	private PrintWriter output = null; // �������ָ��ͻ���
	
	public Client_TCPTest(int port)
	{
		try
		{
			clientSk = new Socket("127.0.0.1", port); // 127.0.0.1 ָ����
			
			input = new BufferedReader(new InputStreamReader(
					clientSk.getInputStream())); // ���������
			output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					clientSk.getOutputStream())), true); // ��������
			
			if (input != null && output != null) // �������ɹ�
			{
				System.out.println("����������ӳɹ���");
				sendResponse("OK");
			}
			else 
			{
				System.out.println("�����������ʧ�ܣ�");
			}
			
			//sendResponse("From Server :Welcome......");
			getRequest();
		}
		catch (IOException e)
		{
			System.out.println("����" + e.getMessage());
		}
		finally
		{
			try
			{
				output.close();
				input.close();
				clientSk.close();
			}
			catch (Exception e)
			{
				// TODO: handle exception
			}
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
	
	//public static void main(String[] args) throws IOException
	//{
	//	Client_TCPTest sa = new Client_TCPTest(8000);
		// sa.getRequest();
	//}
}
