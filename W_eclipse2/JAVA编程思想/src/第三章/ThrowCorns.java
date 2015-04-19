/**
 * 文件名：ThrowCorns.java
 * 项目-包：JAVA编程思想 - 第三章
 * 作者：张文迪
 * 创建日期：2014-9-3
 */
package 第三章;

import java.util.Random;

/**
 * @author 张文迪
 * 类名：ThrowCorns
 * 类说明：练习7，模拟扔硬币的结果
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
    	System.out.println("正"+k);
    	System.out.println("反"+(100-k));
    }
}
