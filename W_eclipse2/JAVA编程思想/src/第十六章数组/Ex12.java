/**
 * �ļ�����Ex12.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-26
 */
package ��ʮ��������;

/**
 * @author ���ĵ�
 * ������Ex12
 * ��˵����
 */
import net.mindview.util.*;
import java.util.*;

public class Ex12 
{
	public static void main(String[] args) 
	{
		double[] da = new double[10];
		CountingGenerator.Double dGen = new CountingGenerator.Double();
		for(int i = 0; i < da.length; i++)
			da[i] = dGen.next();
		System.out.println(Arrays.toString(da));	
	}
}
