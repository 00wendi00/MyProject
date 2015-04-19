/**
 * 文件名：Ex3.java
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
 * 类名：Ex3
 * 类说明：获取文件大小~~~~一种是使用File的length()方法；另外一种是使用FileInputStream的available()方法
 */
public class Ex3
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
			System.out.print(dirItem+" ; ");
		System.out.println();
		for(String dirItem : list)
			System.out.println(new File(path, dirItem).length());
		 							 //根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。 
		System.out.println(path.length());
	}
}
