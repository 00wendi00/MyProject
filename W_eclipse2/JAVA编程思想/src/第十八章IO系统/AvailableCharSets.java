/**
 * 文件名：AvailableCharSets.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-2
 */
package 第十八章IO系统;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;
import static net.mindview.util.Print.*;

/**
 * @author 张文迪
 * 类名：AvailableCharSets
 * 类说明：
 */
public class AvailableCharSets
{
	public static void main(String args[])
	{
		SortedMap<String, Charset> charSets = Charset.availableCharsets();
						//16 位的 Unicode 代码单元序列和字节序列之间的指定映射关系
		Iterator<String> it = charSets.keySet().iterator();
		while(it.hasNext())
		{
			String csName = it.next();
			printnb(csName);
			Iterator aliases = charSets.get(csName).aliases().iterator();
												//返回包含此 charset 各个别名的集合
			if(aliases.hasNext())
				printnb(": ");
			while(aliases.hasNext())
			{
				printnb(aliases.next());
				if(aliases.hasNext())
					System.out.print(", ");
			}
		}
	} 					
}
