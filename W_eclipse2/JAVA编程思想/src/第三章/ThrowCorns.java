/**
 * �ļ�����ThrowCorns.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-3
 */
package ������;

import java.util.Random;

/**
 * @author ���ĵ�
 * ������ThrowCorns
 * ��˵������ϰ7��ģ����Ӳ�ҵĽ��
 */
public class ThrowCorns
{   
	
    public static void main(String args[])
    {
    	int a,k = 0; 
    	Random rand = new Random();
    	for(int i=0;i<100;i++)
    	{   
    		a =rand.nextInt(2);
    		if(a==0)
    		{
    			k++;
    		}
    	}
    	System.out.println("��"+k);
    	System.out.println("��"+(100-k));
    }
}
