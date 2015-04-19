/**
 * 文件名：NetInfoTest.java
 * 项目-包：网络编程 - code1
 * 作者：张文迪
 * 创建日期：2014-6-15
 */
package code1;

/**
 * @author 张文迪
 * 类名：NetInfoTest
 * 类说明：
 */

//NetInfoTest.java
import java.net.*;

public class NetInfoTest
{// 使用InetAddress来获取本机名称和IP地址信息
	public static void main(String[] args)
	{
		new NetInfoTest().display();
	}

	public void display()
	{// 查看本机名称和IP地址
		try
		{
			InetAddress i = InetAddress.getLocalHost();
			System.out.println("本机规范机器名：" + i.getCanonicalHostName());
			System.out.println("是否是本地回环地址： " + i.isLoopbackAddress());
			System.out.println("本机名称和IP地址:  " + i); // 计算机名称和IP地址
			System.out.println("本机名称:  " + i.getHostName());// 计算机名称
			System.out.println("IP地址:  " + i.getHostAddress());// IP地址
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
