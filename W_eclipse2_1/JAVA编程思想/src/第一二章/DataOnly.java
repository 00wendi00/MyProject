/**
 * �ļ�����DataOnly.java
 * ��Ŀ-����JAVA���˼�� - ��һ����
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-2
 */
package ��һ����;

/**
 * @author ���ĵ�
 * ������DataOnly
 * ��˵������ϰ4,5
 */
public class DataOnly
{
	
	static int i;
    static double d;
    static boolean b;

	public static void main(String args[])
	{
     
     
     DataOnly data = new DataOnly();
     
     data.i=2;
     data.d=3;
     data.b=true;
     
     System.out.println(i);
     System.out.println(d);
     System.out.println(b);
     System.out.println(data.i);
     System.out.println(data.d);
     System.out.println(data.b);
     
     
     }
}