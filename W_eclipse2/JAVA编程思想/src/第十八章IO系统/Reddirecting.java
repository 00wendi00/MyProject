/**
 * 文件名：Reddirecting.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-2
 */
package 第十八章IO系统;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * @author 张文迪
 * 类名：Reddirecting
 * 类说明： 但是我们不能把BufferedStream当成是实际可用的流，其实它们必须包装一个代表真实的IO设备的流才能操作，比如说System.in和System.out，或者是数组和字符串（另一种包装的流）。
		比如说InputStream可以这样用：
		InputStream in = new BufferedInputStream(new BufferedInputStream(System.in));
		而字符流呢？
    	其实字符流没有实际的形式，只能是通过包装一些特别的输入流才能进行字符操作，比如说包装字节流InputStream：
		Reader reader = new InputStreamReader(System.in);
		再比如说包装字符数组：
		char[] in = new char[1024];
		Reader reader = new CharArrayReader(in);
 * 
 * 
 *   流  ： 代表任何有能力产出数据的    数据源对象    或者   有能力接收数据的  接收端对象~~
 */
public class Reddirecting
{
	public static void main(String args[]) throws IOException
	{
		PrintStream console = System.out;
		BufferedInputStream in  = new BufferedInputStream(
				new FileInputStream("C:/Users/张文迪/Desktop/新建文件夹1/2.txt"));
		PrintStream out = new PrintStream(
				new BufferedOutputStream(new FileOutputStream("C:/Users/张文迪/Desktop/新建文件夹1/3.txt")));
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s ;
		while((s = br.readLine()) != null)
			System.out.println(s);
		out.close();
		System.setOut(console);
	}
}
