/**
 * �ļ�����Long.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-3
 */
package ������;

/**
 * @author ���ĵ�
 * ������Long
 * ��˵������ϰ8��   û��Ϊ���� Long ���巽�� toBinaryString��long��
 */
public class Long
{
    public static void main(String args[])
    {
    	long n1 = 0xfffff;
    	long n2 = 0132654564;
    	System.out.println("n1 "+Long.toBinaryString(n1));
    	System.out.println("n2 "+Long.toBinaryString(n2));
    }
}
