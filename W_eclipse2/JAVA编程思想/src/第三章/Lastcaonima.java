/**
 * �ļ�����Lastcaonima.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-3
 */
package ������;

/**
 * @author ���ĵ�
 * ������Lastcaonima
 * ��˵������ϰ14+++�����в���
 */
public class Lastcaonima
{
	public static void main(String args[])
	{
		String s1;
		String s2;
		s1 = args[0];
		s2 = args[1];
		if(s1==s2)
		{
			System.out.println("���");
		}
		else
		{
			System.out.println("����");
		}
		if(s1.equals(s2))
		{
			System.out.println("���");
			
		}
		else 
		{
			System.out.println("����");
		}
		
		System.out.println(args[0]);
		
		
		if(args.length==0)                     //û����������������������
		    System.out.println("No command line arguments");
		  else                                   //���������������
		      {
		       System.out.println("Command line arguments were: ");
		       for(int i=0;i<args.length;i++)    //ѭ�����������������յ��Ĳ���
		           System.out.println("Argument"+(i+1)+":"+args[i]);
		      }
	}
}
