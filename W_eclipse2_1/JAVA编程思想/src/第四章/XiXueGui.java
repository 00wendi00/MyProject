/**
 * �ļ�����XiXueGui.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-5
 */
package ������;

/**
 * @author ���ĵ�
 * ������XiXueGui
 * ��˵����  ��ϰ10 ��+++++for(;b<100;b++)�� for(b=11;b<100;b++)�����𣿣�������������������
 */
public class XiXueGui
{
     public static void main(String args[])
     {
    	 int a = 11, b = 11 ;
    	 int c;
    	 for(a=11;a<100;a++)
    	 {
    		 for(b<100;b++)
    		 {
    			 c = a*b;
    			 
    			 if((Integer.toString(c).length()==4)!=((a%10==0)&&(b%10==0)))
    			 {
    				 System.out.println(a+" "+b+" "+c);
    				 
    			 }
    		 }
    	 }
     }
}
