/**
 * 文件名：TestArray.java
 * 项目-包：JAVA编程思想 - 第五章初始化与清理
 * 作者：张文迪
 * 创建日期：2014-9-6
 */
package 第五章初始化与清理;

import javax.swing.JOptionPane;

/**
 * @author 张文迪
 * 类名：TestArray
 * 类说明：练习16,17,18.   对象应用数组。+++++接受String参数构造器
 */
public class TestArray
{
     public static void main(String args[])
     {
    	 String[] test = {"what","haha","nima","bbbb"};
    	 for(int i=0;i<test.length;i++)
    	 {
    		 System.out.print(test[i]+" ");
    	 }   	 
    	 System.out.println();	
    	 System.out.println();
    	 
 	 
    	Array123.main(new String[]{"haode","jihaode","feichanghaode"}) ;
    	//Array123 array123 = null;
    	Array123 array123 = new Array123();
    	Array123[] a = {array123};
    	
    	
     }
     
}

class Array123
{
	public Array123()
	{
		System.out.println("好的");	
	}	
	
	public static void main(String args[])
	{
		for(String s : args)
			System.err.print(s+" ");
	}
	
	
}

