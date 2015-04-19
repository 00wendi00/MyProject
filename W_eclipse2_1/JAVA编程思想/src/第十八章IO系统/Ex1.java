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
import java.util.HashSet;
import java.util.Set;

import net.mindview.util.TextFile;
/**
 * @author 张文迪
 * 类名：Ex1
 * 类说明：
 */
public class Ex1 
{
	public static void main(final String[] args) 
	{
		File path = new File(".");
		String[] list;
		if(args.length == 0)
			list = path.list();
		else
			list = path.list(new FilenameFilter() 
			{
				private String ext = args[0].toLowerCase();
				public boolean accept(File dir, String name) 
				{
					// Only analyze source files with the specified
					// extension (given as the first command line
					// argument),
					if(name.toLowerCase().endsWith(ext)) 
					{
						// Only filter upon file extension?
						if(args.length == 1)
							return true;
						Set<String> words = new HashSet<String>(
								new TextFile(new File(dir, name).getAbsolutePath(), "\\W+"));
						/*如果此抽象路径名已经是绝对路径名，则返回该路径名字符串，这与 getPath() 方法一样。
						 * 如果此抽象路径名是空抽象路径名，则返回当前用户目录的路径名字符串，该目录由系统属性 user.dir 指定。
						 * 否则，使用与系统有关的方式解析此路径名。在 UNIX 系统上，根据当前用户目录解析相对路径名，可使该路径名成为绝对路径名。
						 * 在 Microsoft Windows 系统上，根据路径名指定的当前驱动器目录（如果有）解析相对路径名，可使该路径名成为绝对路径名；
						 * 否则，可以根据当前用户目录解析它。 
						 */
						for(int i = 1; i < args.length; i++)
							if(words.contains(args[i]))
								return true;
					}
					return false;
				}
			});
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list)
			System.out.println(dirItem);
	}
}
