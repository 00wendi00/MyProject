/**
 * 文件名：Test123.java
 * 项目-包：测试2 - 大整数加减乘除
 * 作者：张文迪
 * 创建日期：2014-9-23
 */
package 大整数加减乘除;

/**
 * @author 张文迪
 * 类名：Test123
 * 类说明：
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
