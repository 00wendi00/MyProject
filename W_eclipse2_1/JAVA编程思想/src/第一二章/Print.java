/**
 * �ļ�����Print.java
 * ��Ŀ-����JAVA���˼�� - ��һ����
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-3
 */
package ��һ����;

/**
 * @author ���ĵ�
 * ������Print
 * ��˵������ϰ10������������
 */
public class Print
{
     public static void main(String args[])
     {
    	 int i;    	 
    	 double a,b,c;
    	 for(i=0;i<10;i++)
    	 {
    		Double.parseDouble(args[i]);
    	 }
    	 
    	 a = Double.parseDouble(args[7]);
    	 b = Double.parseDouble(args[8]);
    	 c = Double.parseDouble(args[9]); 
    	 
    	 System.out.print(a);
    	 System.out.println("�±���"+ 7 );
    	 System.out.print(b);
    	 System.out.println("�±���"+ 8);
    	 System.out.print(c);
    	 System.out.println("�±���"+ 9);
     }
}
