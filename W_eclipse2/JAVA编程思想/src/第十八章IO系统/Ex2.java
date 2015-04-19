/**
 * 文件名：Ex2.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-10-31
 */
package 第十八章IO系统;



/**
 * @author 张文迪
 * 类名：Ex2
 * 类说明：练习2 ~~  定制自己的目录构造器~~~
 */
import static net.mindview.util.Print.print;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;


class SortedDirList   //这里用匿名内部类~~~
{
	private File path;
	public SortedDirList() { path = new File("."); }
	public SortedDirList(File path) { this.path = path; }
	public String[] list() 
	{
		String[] list = path.list();
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		return list;
	}
	public String[] list(final String fn_regex)   //这里是  final regex !!!!!!!!!!!
	{
		String[] list = path.list(new FilenameFilter() 
		{
			private Pattern pattern = Pattern.compile(fn_regex);
			public boolean accept(File dir, String name) 
			{
				return pattern.matcher(name).matches();    // arrays  !!!
			}
		});
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		return list;
	}
}
public class Ex2 
{
	public static void main(String args[]) 
	{
		// Default constructor == current directory
		SortedDirList dir = new SortedDirList();
		print(Arrays.asList(dir.list()));
		print(Arrays.asList(dir.list("W.*\\.java")));
	}
}