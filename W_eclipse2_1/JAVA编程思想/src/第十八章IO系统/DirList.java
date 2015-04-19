/**
 * 文件名：DirList.java
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
 * 类名：DirList
 * 类说明：File f = new File(".");当前目录       
 * 		File f = new File("../");是当前目录的上以目录
 */
public class DirList
{
	public static void main(String args[])
	{
		File path = new File(".");
		String[] list;
		if(args.length == 0)
			list = path.list(); //返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录
		else 
			list = path.list(new DirFilter(args[0]));
		
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list)
			System.out.println(dirItem);
	}
}

class DirFilter implements FilenameFilter
{
	private Pattern pattern;
	public DirFilter(String regex)
	{
		pattern = Pattern.compile(regex);
	}
	public boolean accept(File dir, String name)
	{
		return pattern.matcher(name).matches();//尝试将整个区域与模式匹配。 
											  //如果匹配成功，则可以通过 start、end 和 group 方法获取更多信息。 
	}
}
