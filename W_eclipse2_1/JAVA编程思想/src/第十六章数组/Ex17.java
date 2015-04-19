/**
 * �ļ�����Ex17.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-27
 */
package ��ʮ��������;

/**
 * @author ���ĵ�
 * ������Ex17
 * ��˵����
 */
import java.math.*;
import net.mindview.util.*;
import java.util.*;

class BigDecimalGenerator implements Generator<BigDecimal> 
{
	private BigDecimal bd = new BigDecimal(0.0);
	public BigDecimal next() 
	{
		return bd = bd.add(new BigDecimal(1.0));
	}
}

public class Ex17 
{
	public static void main(String[] args) 
	{
		BigDecimal[] bda1 = new BigDecimal[4];
		Generated.array(bda1, new BigDecimalGenerator());
		System.out.println(Arrays.toString(bda1));
		BigDecimal[] bda2 = Generated.array(BigDecimal.class, new BigDecimalGenerator(), 9);
		System.out.println(Arrays.toString(bda2));
	}
}