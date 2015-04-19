/**
 * �ļ�����Generators.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���·���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-21
 */
package ��ʮ���·���;

import java.util.Collection;

import net.mindview.util.Generator;

/**
 * @author ���ĵ�
 * ������Generators
 * ��˵����
 */
public class Generators
{
	public static <T> Collection<T> 
			fill(Collection<T> coll,Generator<T> gen,int n)
	{
		for(int i =0;i<n;i++)
			coll.add(gen.next());
		return coll;
	}
}
