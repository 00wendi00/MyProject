/**
 * �ļ�����Client_TCP.java
 * ��Ŀ-���������� - code2
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-15
 */
package code2;

/**
 * @author ���ĵ�
 * ������Client_TCP
 * ��˵����
 */

//Client_TCP.java
import java.io.*;
import java.net.*;


public class Client_TCP
{// ��������һ���򵥵Ŀͻ��ˣ������ͷ���������
	public static void main(String[] arges)
	{
		try
		{
			//InetAddress addr = InetAddress.getByName(null);// ��ȡһ��IP��null��ʾ����
			Socket sk = new Socket("127.0.0.1", 8000);// ��8000�˿ڣ����������������
			//DataInputStream input = null; // �����������Է�������
			//PrintStream output = new PrintStream(sk.getOutputStream());
			DataOutputStream output = null; // �������ָ���������
			//input = new DataInputStream(sk.getInputStream()); // ���������
			output = new DataOutputStream(sk.getOutputStream()); // ��������
			//System.out.println(input.readUTF());// ���շ�������Ϣ
			//output.writeUTF("From Client: Hello....");// �������������Ϣ
			output.writeUTF("Hello....");
			output.flush();
			output.close();
			sk.close();
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
