/**
 * �ļ�����Sushu.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-4
 */
package ������;

/**
 * @author ���ĵ�
 * ������Sushu
 * ��˵������ϰ4���Ҵ�ӡ ����
 */
public class Sushu
{
   public static void main(String args[])
   {
	   boolean a = true;
	   for(int m = 2;m>0;m++)
	   {
		   for(int n = 2;n<m;n++ )
		   {
			    a = a&((m%n)!=0) ;			    
		   }
		   if(a)
		   {
			   System.out.println(m);		   
		   }
		   a = true;
	   }
   }
}
