/**
 * �ļ�����TestUDPClient.java
 * ��Ŀ-���������� - code2
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-15
 */
package code2;

/**
 * @author ���ĵ�
 * ������TestUDPClient
 * ��˵����
 */


import java.net.*;
import java.io.*;

public class TestUDPClient
{
	public static void main(String args[]) throws Exception
	{
		/*
		long n = 10000L;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  //������ϵͳ�Զ�����
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeLong(n);

		byte[] buf = baos.toByteArray();//�õ��Ǹ��Զ�������ֽ����顣
		*/
		byte[] buf = new String("hello!").getBytes();

		System.out.println(buf.length);

		DatagramPacket dp = new DatagramPacket(buf, buf.length,
				new InetSocketAddress("127.0.0.1", 5678));  //InetSocketAddress������������ϵĵ�ַ��
		DatagramSocket ds = new DatagramSocket(9999);  //�����������9999�˿���5678�˿ڷ��Ͱ���
		
		while(true)
		{
		    ds.send(dp);  //�������ݰ�
		    Thread.sleep(100);
		}
		
		//ds.close();
	}
}