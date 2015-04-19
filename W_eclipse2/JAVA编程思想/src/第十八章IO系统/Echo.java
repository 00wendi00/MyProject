/**
 * 文件名：Echo.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-2
 */
package 第十八章IO系统;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 张文迪
 * 类名：Echo
 * 类说明：
 */
public class Echo
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while( (s = stdin.readLine()) != null && s.length() != 0)
			System.out.println(s+"!");
		stdin.close();
	}
}
