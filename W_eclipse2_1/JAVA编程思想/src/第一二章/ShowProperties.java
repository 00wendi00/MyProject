package ��һ����;
/**
 * �ļ�����ShowProperties.java
 * ��Ŀ-��������2 - 
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-2
 */

/**
 * @author ���ĵ�
 * ������ShowProperties
 * ��˵����listing properties
 */
public class ShowProperties
{
      public static void main(String args[])
      {
    	  System.getProperties().list(System.out);
    	  System.out.println(System.getProperty("user.name"));
    	  System.out.println(System.getProperty("java.labrary.path"));
      }
}
