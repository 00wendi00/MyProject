/**
 * 文件名：Print.java
 * 项目-包：JAVA编程思想 - 第一二章
 * 作者：张文迪
 * 创建日期：2014-9-3
 */
package 第一二章;

/**
 * @author 张文迪
 * 类名：Print
 * 类说明：练习10，命令行输入
 */
public class Print
{
     public static void main(String args[])
     {
    	 int i;    	 
    	 double a,b,c;
    	 for(i=0;i<10;i++)
    	 {
    		Double.parseDouble(args[i]);
    	 }
    	 
    	 a = Double.parseDouble(args[7]);
    	 b = Double.parseDouble(args[8]);
    	 c = Double.parseDouble(args[9]); 
    	 
    	 System.out.print(a);
    	 System.out.println("下标是"+ 7 );
    	 System.out.print(b);
    	 System.out.println("下标是"+ 8);
    	 System.out.print(c);
    	 System.out.println("下标是"+ 9);
     }
}
