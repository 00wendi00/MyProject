/**
 * 文件名：XiXueGui.java
 * 项目-包：JAVA编程思想 - 第四章
 * 作者：张文迪
 * 创建日期：2014-9-5
 */
package 第四章;

/**
 * @author 张文迪
 * 类名：XiXueGui
 * 类说明：  练习10 。+++++for(;b<100;b++)和 for(b=11;b<100;b++)的区别？？？？？？？？？？？
 */
public class XiXueGui
{
     public static void main(String args[])
     {
    	 int a = 11, b = 11 ;
    	 int c;
    	 for(a=11;a<100;a++)
    	 {
    		 for(b<100;b++)
    		 {
    			 c = a*b;
    			 
    			 if((Integer.toString(c).length()==4)!=((a%10==0)&&(b%10==0)))
    			 {
    				 System.out.println(a+" "+b+" "+c);
    				 
    			 }
    		 }
    	 }
     }
}
