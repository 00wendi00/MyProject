/**
 * �ļ�����Ex3.java
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
 * ������Ex3
 * ��˵������ȡ�ļ���С~~~~һ����ʹ��File��length()����������һ����ʹ��FileInputStream��available()����
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
		 							 //���� parent ����·������ child ·�����ַ�������һ���� File ʵ���� 
		System.out.println(path.length());
	}
}
