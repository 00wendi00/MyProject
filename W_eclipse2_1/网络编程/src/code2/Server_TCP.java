/**
 * �ļ�����Server_TCP.java
 * ��Ŀ-���������� - code2
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-15
 */
package code2;

/**
 * @author ���ĵ�
 * ������Server_TCP
 * ��˵����
 */

//Server_TCP.java
import java.io.*;
import java.net.*;

public class Server_TCP
{
	ServerSocket svrSkt = null;// �������׽���
	Socket cltSkt = null;// �ͻ����׽���
	DataInputStream input = null; // �����������Կͻ���
	PrintStream output = null; // �������ָ��ͻ���

	public Server_TCP(int port)
	{
		System.out.println("���������ڼ������˿ڣ�" + port);
		try
		{
			svrSkt = new ServerSocket(port); // ��ʼ����
		} catch (IOException e)
		{
			System.out.println("�����˿�" + port + "ʧ��");
		}
		try
		{
			cltSkt = svrSkt.accept(); //���������ܵ����׽��ֵ��������󡣴˷��������Ӵ���֮ǰһֱ������
		} catch (IOException e)
		{
			System.out.println("����ʧ��");
		}
		try
		{
			input = new DataInputStream(cltSkt.getInputStream()); // ���������
			output = new PrintStream(cltSkt.getOutputStream()); // ��������
			
			if(input==null||output==null)
				System.out.println("error!");
			
			//String str = null;
			//str = input.readUTF();
			//System.out.println(str);
		} catch (IOException e)
		{
		}
		//output.println("From Server :Welcome......");
	}

	public String getRequest()
	{// ��ȡ�ӿͻ��˽��յ���Ϣ
		String frmClt = null;
		try
		{
			frmClt = input.readUTF();
			System.out.println(frmClt);
		} catch (Exception e)
		{
			//System.out.println("�޷���ȡ�˿�.....");
			//System.exit(0);
			e.printStackTrace();
		}
		return frmClt;
	}

	public void sendResponse(String message)
	{// ��ͻ��˷�����Ϣ
		try
		{
			output.println(message);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException
	{
		Server_TCP sa = new Server_TCP(8000);
		sa.getRequest();
	}
}
