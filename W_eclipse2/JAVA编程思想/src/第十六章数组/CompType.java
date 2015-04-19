/**
 * �ļ�����CompType.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-27
 */
package ��ʮ��������;

import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

/**
 * @author ���ĵ�
 * ������CompType
 * ��˵������ϰ21 ������Ԫ�صıȽϣ�ʵ��java.lang.Comparable �ӿ�~~~~~~��Collections �е�reverseOrder()��������Comparator ,��˳��
 */
public class CompType implements Comparable<CompType>  //����
{
	int i,j;
	private static int count = 1;
	public CompType(int n1,int n2)
	{
		i = n1;
		j = n2;
	}
	public String toString()
	{
		String result = "[i=" + i + ",j="+j+"]";
		if(count++%3 == 0)
			result +="\n";
		return result;
	}
	public int compareTo(CompType rv)
	{
		return (i<rv.i ?  -1:(i==rv.i ? 0:1));
	}
	private static Random r = new Random(47);
	public static Generator<CompType> generator()
	{
		return new Generator<CompType>()
		{
			public CompType next()
			{
				return new CompType(r.nextInt(80), r.nextInt(70));
			}
		};
	}
	public static void main(String args[])
	{
		CompType[] a = Generated.array(new CompType[12], generator());
		print("before sorting:");
		print(Arrays.toString(a));
		Arrays.sort(a);
		print("after sorting:");
		print(Arrays.toString(a));
		
		print("after sorting222:");
		Arrays.sort(a,Collections.reverseOrder());// ~��������������������������������
		print(Arrays.toString(a));
	}
}
