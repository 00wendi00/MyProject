/**
 * 文件名：BeginEnd.java
 * 项目-包：JAVA编程思想 - 第四章
 * 作者：张文迪
 * 创建日期：2014-9-4
 */
package 第四章;

/**
 * @author 张文迪
 * 类名：BeginEnd
 * 类说明:  练习 6.   return
 */
public class BeginEnd
{
	static int test(int testval,int begin,int end)
	{
		if(begin<testval&&testval<end)
			return +1;
		else if (begin>testval||testval>end) 
		{
			return -1;
		}
		else 
		{
			return 0;
		}
	}
	
    public static void main(String args[])
    {
    	System.out.println(test(10,  3, 2));
    	System.out.println(test(6,  5, 9));
    	System.out.println(test(2,  2, 20));
    }
}
