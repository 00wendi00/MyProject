/**
 * �ļ�����TestArray.java
 * ��Ŀ-����JAVA���˼�� - �����³�ʼ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-6
 */
package �����³�ʼ��������;

import javax.swing.JOptionPane;

/**
 * @author ���ĵ�
 * ������TestArray
 * ��˵������ϰ16,17,18.   ����Ӧ�����顣+++++����String����������
 */
public class TestArray
{
     public static void main(String args[])
     {
    	 String[] test = {"what","haha","nima","bbbb"};
    	 for(int i=0;i<test.length;i++)
    	 {
    		 System.out.print(test[i]+" ");
    	 }   	 
    	 System.out.println();	
    	 System.out.println();
    	 
 	 
    	Array123.main(new String[]{"haode","jihaode","feichanghaode"}) ;
    	//Array123 array123 = null;
    	Array123 array123 = new Array123();
    	Array123[] a = {array123};
    	
    	
     }
     
}

class Array123
{
	public Array123()
	{
		System.out.println("�õ�");	
	}	
	
	public static void main(String args[])
	{
		for(String s : args)
			System.err.print(s+" ");
	}
	
	
}

