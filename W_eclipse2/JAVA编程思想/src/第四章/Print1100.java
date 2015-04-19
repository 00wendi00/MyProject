/**
 * 文件名：Print1100.java
 * 项目-包：JAVA编程思想 - 第四章
 * 作者：张文迪
 * 创建日期：2014-9-4
 */
package 第四章;

import java.util.Random;

/**
 * @author 张文迪
 * 类名：Print1100
 * 类说明：  练习 1,2,3
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
    			System.out.print("大于"+m+" ");
    		else if (p < m) 
			{
				System.out.print("小于"+m+" ");
			}
    		else 
			{
				System.out.print("等于"+m+" ");
			}
    		p = m;
    	}
    	System.out.println();
    	System.out.println("000000000000000000000000000");
    	
        }
    	
    }
}
