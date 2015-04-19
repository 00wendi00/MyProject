/**
 * 文件名：Storage.java
 * 项目-包：JAVA编程思想 - 第一二章
 * 作者：张文迪
 * 创建日期：2014-9-2
 */
package 第一二章;

/**
 * @author 张文迪
 * 类名：Storage
 * 类说明：练习6。返回值
 */
public class Storage
{   
	
	static int storage(String s)
	{
		return s.length()*2;
	}
	
	
	public static void main(String args[])
	{
		String p =new String();
		p="00000000000000";
		System.out.println(storage(p));
	}
}


