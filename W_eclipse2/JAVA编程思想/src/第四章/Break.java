/**
 * �ļ�����Break.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-4
 */
package ������;

/**
 * @author ���ĵ�
 * ������Break
 * ��˵����  ��ϰ7 ��break��return ���ѭ��
 */
public class Break
{
     public static void main(String args[])
     {
    	 int i=0;
    	 while(true)
    	 {
    		 i++;
    		 System.out.println(i);
    		 if(i==99)
    			 break;
    	 }
    	 
    	 
    	 int k = 0;
    	 while(true)
    	 {
    		 k++;
    		 System.out.println(k);
    		 if(k==99)
    			 return;
    	 }
     }
}
