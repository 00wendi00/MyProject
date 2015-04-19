/**
 * �ļ�����Ex1.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-31
 */
package ��ʮ����IOϵͳ;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.mindview.util.TextFile;
/**
 * @author ���ĵ�
 * ������Ex1
 * ��˵����
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
						/*����˳���·�����Ѿ��Ǿ���·�������򷵻ظ�·�����ַ��������� getPath() ����һ����
						 * ����˳���·�����ǿճ���·�������򷵻ص�ǰ�û�Ŀ¼��·�����ַ�������Ŀ¼��ϵͳ���� user.dir ָ����
						 * ����ʹ����ϵͳ�йصķ�ʽ������·�������� UNIX ϵͳ�ϣ����ݵ�ǰ�û�Ŀ¼�������·��������ʹ��·������Ϊ����·������
						 * �� Microsoft Windows ϵͳ�ϣ�����·����ָ���ĵ�ǰ������Ŀ¼������У��������·��������ʹ��·������Ϊ����·������
						 * ���򣬿��Ը��ݵ�ǰ�û�Ŀ¼�������� 
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
