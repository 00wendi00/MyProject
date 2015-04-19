/**
 * 文件名：GetURL.java
 * 项目-包：网络编程 - code1
 * 作者：张文迪
 * 创建日期：2014-6-15
 */
package code1;

/**
 * @author 张文迪
 * 类名：GetURL
 * 类说明：
 */

//GetURL.java
import java.io.*;
import java.net.*;

public class GetURL
{// 通过使用URL类，构造一个输入对象，并读取其内容。
	public static void main(String arg[])
	{
		if (arg.length != 1) //至少要有一个命令行参数，且改参数必须符合一定的协议规范。
		{
			System.out.println("你应该输入一个URL地址来获取相关测试信息！");
			return;
		}
		new GetURL(arg[0]);  //通过命令行参数传入
	}

	public GetURL(String URL)
	{// 输入参数：String URL 互联网的网页地址。
		try
		{
			URL url = new URL(URL);// 创建一个URL对象
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream()));// 创建一个使用默认大小输入缓冲区的缓冲字符输入流 ， InputStreamReader 是字节流通向字符流的桥梁 ，读取从服务器返回的所有文本  
			String str;
			while ((str = in.readLine()) != null)//判断是否已经读完
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
