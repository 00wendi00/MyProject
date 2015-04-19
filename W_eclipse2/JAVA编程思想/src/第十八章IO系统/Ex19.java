/**
 * 文件名：Ex19.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-2
 */
package 第十八章IO系统;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 张文迪
 * 类名：Ex19
 * 类说明：
 */
public class Ex19
{
	public static void main(String args[]) throws IOException
	{
		Map<Byte, Integer> map = new  HashMap<Byte, Integer>();
		byte[] by = BinaryFile.read("C:/Users/张文迪/Desktop/新建文件夹1/5.txt");
		for(int i = 0;i<by.length;i++)
		{
			Integer k = map.get(by);
			map.put(by[i], k==null ? 1:k+1);
		}
		System.out.println(map.containsKey('6'));
		
	//	for(int i = 0;i<by.length;i++)
		//	System.out.println(Byte.toString(by[i]));
		
		System.out.println(map);
	}
}
