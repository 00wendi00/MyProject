/**
 * �ļ�����Print1100.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-4
 */
package ������;

import java.util.Random;

/**
 * @author ���ĵ�
 * ������Print1100
 * ��˵����  ��ϰ 1,2,3
 */
public class Print1100
{
    public static  void main(String args[])
    {
    	int i = 0;
    	while(i<100)
    	{
    		i++;
    		System.out.print(i);
    	}
    	System.out.println();
    	
    	
    	
    	while(i!=0)
    	{	
    	
    	
    	
    	int k = 0,m,p;
    	p = (int) (Math.random()*100);
    	
    	for(k = 0;k<24;k++)
    	{
    		m = (int) (Math.random()*100);
    		if(p > m)
    			System.out.print("����"+m+" ");
    		else if (p < m) 
			{
				System.out.print("С��"+m+" ");
			}
    		else 
			{
				System.out.print("����"+m+" ");
			}
    		p = m;
    	}
    	System.out.println();
    	System.out.println("000000000000000000000000000");
    	
        }
    	
    }
}
