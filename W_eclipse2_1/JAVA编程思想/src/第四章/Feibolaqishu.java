/**
 * �ļ�����Feibolaqishu.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-4
 */
package ������;

import javax.swing.JOptionPane;

/**
 * @author ���ĵ�
 * ������Feibolaqishu
 * ��˵������ϰ9.  + String ǿ��ת��Ϊ int
 */
public class Feibolaqishu
{
    public static void main(String args[])
    {
    	
    	int a;
    	a = Integer.parseInt(JOptionPane.showInputDialog(5));
    	//a = Integer.parseInt(args[0]);
    	int s = 1,k = 0,t=0;
    	for(int i = 0;i<a;i++)
    	{
    		
    		System.out.print(s+" ");
    		t=s;
    		s=k+s;
    		k=t;
		
    	}
    }
}
