/**
 * �ļ�����Ex2.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-31
 */
package ��ʮ����IOϵͳ;



/**
 * @author ���ĵ�
 * ������Ex2
 * ��˵������ϰ2 ~~  �����Լ���Ŀ¼������~~~
 */
import static net.mindview.util.Print.print;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;


class SortedDirList   //�����������ڲ���~~~
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
	public String[] list(final String fn_regex)   //������  final regex !!!!!!!!!!!
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