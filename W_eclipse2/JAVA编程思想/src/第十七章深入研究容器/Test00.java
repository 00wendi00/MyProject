/**
 * 文件名：Test.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-30
 */
package 第十七章深入研究容器;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张文迪
 * 类名：Test
 * 类说明：
 */
public class Test00
{
	public static void main(String args[])
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("~", 1);
		map.put("!", 2);
		map.put("@", 3);
		System.out.println(map);
		map.clear();
		System.out.println(map);
	}
}
