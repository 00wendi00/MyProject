/**
 * �ļ�����GetURLTest.java
 * ��Ŀ-���������� - code1
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-15
 */
package code1;

/**
 * @author ���ĵ�
 * ������GetURLTest
 * ��˵����
 */

//GetURLTest.java
import java.io.*;
import java.net.*;

public class GetURLTest
{// ͨ��ʹ��URL�࣬����һ��������󣬲���ȡ�����ݡ�
	public static void main(String[] arg)
	{
		if (arg.length != 1)
		{
			System.out.println("��Ӧ������һ��URL��ַ����ȡ��ز�����Ϣ��");
			return;
		}
		new GetURLTest(arg[0]);
	}

	public GetURLTest(String URL)
	{// ���������String URL ����������ҳ��ַ��
		try
		{
			URL url = new URL(URL);// ����һ��URL����
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getProtocol());
			System.out.println(url.getUserInfo());
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream()));// ��ȡ�ӷ��������ص������ı�
			String str;
			while ((str = in.readLine()) != null)
			{
				display(str);// ������ı�����
			}
			in.close();
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void display(String s)
	{
		if (s != null)
			System.out.println(s);
	}
}
