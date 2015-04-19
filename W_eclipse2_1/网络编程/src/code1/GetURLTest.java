/**
 * 文件名：GetURLTest.java
 * 项目-包：网络编程 - code1
 * 作者：张文迪
 * 创建日期：2014-6-15
 */
package code1;

/**
 * @author 张文迪
 * 类名：GetURLTest
 * 类说明：
 */

//GetURLTest.java
import java.io.*;
import java.net.*;

public class GetURLTest
{// 通过使用URL类，构造一个输入对象，并读取其内容。
	public static void main(String[] arg)
	{
		if (arg.length != 1)
		{
			System.out.println("你应该输入一个URL地址来获取相关测试信息！");
			return;
		}
		new GetURLTest(arg[0]);
	}

	public GetURLTest(String URL)
	{// 输入参数：String URL 互联网的网页地址。
		try
		{
			URL url = new URL(URL);// 创建一个URL对象
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getProtocol());
			System.out.println(url.getUserInfo());
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream()));// 读取从服务器返回的所有文本
			String str;
			while ((str = in.readLine()) != null)
			{
				display(str);// 这里读文本出来
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
