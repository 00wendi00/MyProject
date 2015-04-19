/**
 * 文件名：Break.java
 * 项目-包：JAVA编程思想 - 第四章
 * 作者：张文迪
 * 创建日期：2014-9-4
 */
package 第四章;

/**
 * @author 张文迪
 * 类名：Break
 * 类说明：  练习7 。break，return 打断循环
 */
public class Break
{
     public static void main(String args[])
     {
    	 int i=0;
    	 while(true)
    	 {
    		 i++;
    		 System.out.println(i);
    		 if(i==99)
    			 break;
    	 }
    	 
    	 
    	 int k = 0;
    	 while(true)
    	 {
    		 k++;
    		 System.out.println(k);
    		 if(k==99)
    			 return;
    	 }
     }
}
