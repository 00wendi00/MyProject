/**
 * �ļ�����Twointeger1.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-4
 */
package ������;

/**
 * @author ���ĵ�
 * ������Twointeger1
 * ��˵������ϰ5????????????????��Ԫ������     //��� 2���ƣ�8���� ��16���� ������������������  //int ��ת��ΪString��  --- 3�ַ���
 */
public class Twointeger1
{
	public static void main(String args[])
    {
    	int m=0x10101010;
    	int n=0x101010;
    	System.out.println(m);
    	System.out.println(n);
    	System.out.println();
    	
    	System.out.println(String.valueOf(m));//ת��ΪString  
    	System.out.println(m+"");//ת��ΪString 
    	System.out.println(Integer.toString(m));//ת��ΪString 
    	System.out.println();
    	    	
    	System.out.println();
    	
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
    	System.out.println();
    	
    	
    	
    	it k = 0x1010101;
    	int j = 0x101010;
    	
    	
    	
    }
}
