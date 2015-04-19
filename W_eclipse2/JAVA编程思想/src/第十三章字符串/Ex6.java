/**
 * �ļ�����Ex6.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����ַ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-14
 */
package ��ʮ�����ַ���;

/**
 * @author ���ĵ�
 * ������Ex6
 * ��˵����String.format(" i = %d\n l = %d\n f = %.16g\n d = %.16g\n", i, l, f, d);
 * 										  f = %.16g\n
 */
public class Ex6
{
	private int i = 0;
	private long l = 0;
	private float f = 0.0f;
	private double d = 0.0;
	Ex6
	(int i, long l, float f, double d) 
	{
		this.i = i;
		this.l = l;
		this.f = f;
		this.d = d;
	}
	public String toString() 
	{
		return String.format(" i = %d\n l = %d\n f = %.16g\n d = %.16g\n", i, l, f, d);
	}
	public static void main(String[] args) 
	{
		Ex6 x = new Ex6(2, 45l, 1.2f, 2.7182818289);
		Ex6 ex = new Ex6(-2147483648, -9223372036854775808L, 1.1754943508222875E-38f, 2.2250738585072014E-308);
		Ex6 exMax = new Ex6(2147483647, 9223372036854775807L, 3.4028234663852886E38f, 1.7976931348623157E308);
		System.out.println(x);
		System.out.println(ex);
		System.out.println(exMax);
	}
}
