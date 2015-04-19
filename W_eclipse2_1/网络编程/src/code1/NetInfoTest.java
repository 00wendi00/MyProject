/**
 * �ļ�����NetInfoTest.java
 * ��Ŀ-���������� - code1
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-15
 */
package code1;

/**
 * @author ���ĵ�
 * ������NetInfoTest
 * ��˵����
 */

//NetInfoTest.java
import java.net.*;

public class NetInfoTest
{// ʹ��InetAddress����ȡ�������ƺ�IP��ַ��Ϣ
	public static void main(String[] args)
	{
		new NetInfoTest().display();
	}

	public void display()
	{// �鿴�������ƺ�IP��ַ
		try
		{
			InetAddress i = InetAddress.getLocalHost();
			System.out.println("�����淶��������" + i.getCanonicalHostName());
			System.out.println("�Ƿ��Ǳ��ػػ���ַ�� " + i.isLoopbackAddress());
			System.out.println("�������ƺ�IP��ַ:  " + i); // ��������ƺ�IP��ַ
			System.out.println("��������:  " + i.getHostName());// ���������
			System.out.println("IP��ַ:  " + i.getHostAddress());// IP��ַ
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
