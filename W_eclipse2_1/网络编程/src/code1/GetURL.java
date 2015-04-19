/**
 * �ļ�����GetURL.java
 * ��Ŀ-���������� - code1
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-15
 */
package code1;

/**
 * @author ���ĵ�
 * ������GetURL
 * ��˵����
 */

//GetURL.java
import java.io.*;
import java.net.*;

public class GetURL
{// ͨ��ʹ��URL�࣬����һ��������󣬲���ȡ�����ݡ�
	public static void main(String arg[])
	{
		if (arg.length != 1) //����Ҫ��һ�������в������ҸĲ����������һ����Э��淶��
		{
			System.out.println("��Ӧ������һ��URL��ַ����ȡ��ز�����Ϣ��");
			return;
		}
		new GetURL(arg[0]);  //ͨ�������в�������
	}

	public GetURL(String URL)
	{// ���������String URL ����������ҳ��ַ��
		try
		{
			URL url = new URL(URL);// ����һ��URL����
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream()));// ����һ��ʹ��Ĭ�ϴ�С���뻺�����Ļ����ַ������� �� InputStreamReader ���ֽ���ͨ���ַ��������� ����ȡ�ӷ��������ص������ı�  
			String str;
			while ((str = in.readLine()) != null)//�ж��Ƿ��Ѿ�����
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
