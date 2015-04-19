/**
 * �ļ�����DirList.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-31
 */
package ��ʮ����IOϵͳ;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author ���ĵ�
 * ������DirList
 * ��˵����File f = new File(".");��ǰĿ¼       
 * 		File f = new File("../");�ǵ�ǰĿ¼������Ŀ¼
 */
public class DirList
{
	public static void main(String args[])
	{
		File path = new File(".");
		String[] list;
		if(args.length == 0)
			list = path.list(); //����һ���ַ������飬��Щ�ַ���ָ���˳���·������ʾ��Ŀ¼�е��ļ���Ŀ¼
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
		return pattern.matcher(name).matches();//���Խ�����������ģʽƥ�䡣 
											  //���ƥ��ɹ��������ͨ�� start��end �� group ������ȡ������Ϣ�� 
	}
}
