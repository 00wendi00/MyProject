/**
 * 文件名：Cartoon.java
 * 项目-包：JAVA编程思想 - 第七章复用类
 * 作者：张文迪
 * 创建日期：2014-9-8
 */
package 第七章复用类;

/**
 * @author 张文迪
 * 类名：Cartoon
 * 类说明：练习3,4.   ：基类构造器   ：1.总会被调用，2.在 导出类构造器 之前被调用
 */
public class Cartoon extends Drawing
{
     public static void main(String args[])
     {  	 
    	 Cartoon cartoon = new Cartoon();  	 
 	     System.out.println();
    	 Drawing drawing = new Drawing();
     }

	public Cartoon()
	{
		System.out.println("Cartoon construcor");
	}
}
class Drawing extends Art
{
    Drawing()
    {
    	System.out.println("Drawing constructor");
    	
    }
       
}
class Art
{
	Art()
	{
		System.out.println("Art constructor");
	}

}