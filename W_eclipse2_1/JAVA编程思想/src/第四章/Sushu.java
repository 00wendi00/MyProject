/**
 * 文件名：Sushu.java
 * 项目-包：JAVA编程思想 - 第四章
 * 作者：张文迪
 * 创建日期：2014-9-4
 */
package 第四章;

/**
 * @author 张文迪
 * 类名：Sushu
 * 类说明：练习4查找打印 素数
 */
public class Sushu
{
   public static void main(String args[])
   {
	   boolean a = true;
	   for(int m = 2;m>0;m++)
	   {
		   for(int n = 2;n<m;n++ )
		   {
			    a = a&((m%n)!=0) ;			    
		   }
		   if(a)
		   {
			   System.out.println(m);		   
		   }
		   a = true;
	   }
   }
}
