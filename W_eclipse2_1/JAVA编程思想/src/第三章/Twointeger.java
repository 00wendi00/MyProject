/**
 * �ļ�����Twointeger.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-3
 */
package ������;

/**
 * @author ���ĵ�
 * ������Twointeger
 * ��˵����3.10 ��λ������
 */
public class Twointeger
{
    public static void main(String args[])
    {
    	int m=0x10101010;
    	int n=0x101010;
    	System.out.println(m);
    	System.out.println(n);
    	System.out.println(m+n);
    	System.out.println(Integer.toBinaryString(m));
    	System.out.println(Integer.toBinaryString(n));
    	System.out.println();
    	System.out.println(Integer.toBinaryString(m&n));
    	System.out.println(Integer.toBinaryString(m|n));
    	System.out.println(Integer.toBinaryString(m^n));
    	System.out.println(Integer.toBinaryString(m&=n));
    	System.out.println(Integer.toBinaryString(m|=n));
    	System.out.println(Integer.toBinaryString(m^=n));
    	
    }
}
