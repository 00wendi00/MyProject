/**
 *�ļ���:Test4.java
 *��Ŀ-��:���ݽṹ���㷨����,Project1
 *����:���ĵ�
 *ʱ��:2015��4��5��
 */
package Project1;

/**
 * @author ���ĵ�
 * ����:Test4
 * ��˵��:�ݹ�~~~~~
 */
public class Test5 {
	static int c = 0;
	public static void main(String args[]){
		System.out.println(digui(1));
		System.out.println(c);
	}
	public static int digui( int n )
	{
		if( n < 2 )
			return n;	
		c++;
		return n % 2 + digui( n / 2 );
	}
}
