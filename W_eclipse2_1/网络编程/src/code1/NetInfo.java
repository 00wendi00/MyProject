/**
 * �ļ�����NetInfo.java
 * ��Ŀ-���������� - code1
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-15
 */
package code1;

/**
 * @author ���ĵ�
 * ������NetInfo
 * ��˵����
 */

//NetInfo.java
import java.net.*;

public class NetInfo
{// ʹ��InetAddress����ȡ�������ƺ�IP��ַ��Ϣ
	public static void main(String[] args)
	{
		new NetInfo().display();
	}

	public void display()
	{// �鿴�������ƺ�IP��ַ
		try
		{
			InetAddress i = InetAddress.getLocalHost();
			System.out.println("�������ƺ�IP��ַ:  " + i); // ��������ƺ�IP��ַ
			System.out.println("��������:  " + i.getHostName());// ���������
			System.out.println("��������000:  " + i.getCanonicalHostName());// ���������
			System.out.println("IP��ַ:  " + i.getHostAddress());// IP��ַ
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
