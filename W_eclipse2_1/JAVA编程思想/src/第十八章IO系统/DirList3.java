/**
 * 文件名：Ex1.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-10-31
 */
package 第十八章IO系统;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author 张文迪
 * 类名：Ex1
 * 类说明：
 */
public class DirList3
{
	public static void main(final String args[])
	{
		File path = new File(".");
		String[] list;
		if(args.length == 0)
			list = path.list();
		else
			list = path.list(new FilenameFilter()
			{
				private Pattern pattern = Pattern.compile(args[0]);
				public boolean accept(File dir, String name)
				{
					return pattern.matcher(name).matches();					
				}
			});
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list)
			System.out.println(dirItem);
	}
}
