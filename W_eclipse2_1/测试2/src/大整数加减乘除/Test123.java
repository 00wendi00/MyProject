/**
 * �ļ�����Test123.java
 * ��Ŀ-��������2 - �������Ӽ��˳�
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-23
 */
package �������Ӽ��˳�;

/**
 * @author ���ĵ�
 * ������Test123
 * ��˵����
 */
public class Test123
{
    public static void main(String args[])
    {
    	int[] c = new int[10000];
    	int[] d = new int[10000];
    	int[] a = {1,1,5};
    	int[] b = {5};
    	
    	System.out.println();
    	for(int i = 0;i<a.length;i++)
    		System.out.print(a[i]);
    	
    	for(int i = 0; i<a.length-1;i++)
    	{
    		for(int p = 0;p<b.length;p++)
    		{
    		    c[i+1] += a[i]/b[p];
    		    if(a[i]%b[p]!=0)
    		    {   		    	
    		    	a[i+1] += (a[i]%b[p])*10;
    		    	a[i] = 0;
    		    }
    		}
    	}
    	System.out.println();
    	for(int i = 0;i<10;i++)
    		System.out.print(c[i]);
    	System.out.println();    	
    }
}
