/**
 * �ļ�����EnumClass.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����ö������
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-3
 */
package ��ʮ����ö������;

import net.mindview.util.Print.*;

/**
 * @author ���ĵ�
 * ������EnumClass
 * ��˵����
 */
enum Shrubbery { GROUND,CRAWLING,HANGING }
public class EnumClass
{
	public static void main(String args[])
	{
		System.out.println(" !!!!!!!!");
		for(Shrubbery s : Shrubbery.values() )
		{
		     System.out.println(s+ " " + s.ordinal());
		     //����ö�ٳ���������������ö�������е�λ�ã����г�ʼ��������Ϊ�㣩�� ���������Ա����ʹ�ô˷���
		     System.out.print(s.compareTo(Shrubbery.HANGING));
		     System.out.print(s== Shrubbery.CRAWLING);
		     System.out.println(s.getDeclaringClass());
		     System.out.println(s.name());
		     System.out.println("-------------");
		}
		for(String s: "HANGING CRAWLING GROUND".split(" "))
		{
			Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
			System.out.println(shrub);
		}
	}
}
