/**
 * �ļ�����TestUDPServer.java
 * ��Ŀ-���������� - code2
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-15
 */
package code2;

/**
 * @author ���ĵ�
 * ������TestUDPServer
 * ��˵����
 */


import java.net.*;
import java.io.*;

public class TestUDPServer
{
	public static void main(String args[]) throws Exception
	{
		byte buf[] = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length); //newһ���������������buf����UDP�������ݵ������� 
		DatagramSocket ds = new DatagramSocket(5678);
		while (true)
		{
			ds.receive(dp);   //��ʼ���գ�����ʽ�ķ�����
			//ByteArrayInputStream bais = new ByteArrayInputStream(buf);
			//DataInputStream dis = new DataInputStream(bais);
			//System.out.println(dis.readLong());  //��8���ֽ�ת��Ϊlong���͡�
			System.out.println(new String(buf));
		}
	}
}