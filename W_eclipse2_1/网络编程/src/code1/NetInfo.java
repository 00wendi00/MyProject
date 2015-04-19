/**
 * 文件名：NetInfo.java
 * 项目-包：网络编程 - code1
 * 作者：张文迪
 * 创建日期：2014-6-15
 */
package code1;

/**
 * @author 张文迪
 * 类名：NetInfo
 * 类说明：
 */

//NetInfo.java
import java.net.*;

public class NetInfo
{// 使用InetAddress来获取本机名称和IP地址信息
	public static void main(String[] args)
	{
		new NetInfo().display();
	}

	public void display()
	{// 查看本机名称和IP地址
		try
		{
			InetAddress i = InetAddress.getLocalHost();
			System.out.println("本机名称和IP地址:  " + i); // 计算机名称和IP地址
			System.out.println("本机名称:  " + i.getHostName());// 计算机名称
			System.out.println("本机名称000:  " + i.getCanonicalHostName());// 计算机名称
			System.out.println("IP地址:  " + i.getHostAddress());// IP地址
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
