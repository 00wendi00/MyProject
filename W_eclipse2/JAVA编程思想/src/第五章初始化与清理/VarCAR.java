/**
 * 文件名：VarCAR.java
 * 项目-包：JAVA编程思想 - 第五章初始化与清理
 * 作者：张文迪
 * 创建日期：2014-9-6
 */
package 第五章初始化与清理;


/**
 * @author 张文迪
 * 类名：VarCAR
 * 类说明：练习 19,20.可变参数列表。
 */	
public class VarCAR
{
    public static void main(String args[])
    {
    	 f("wqeter","qwe tr","weyut");
    	 f(new String[]{"weqwewe","wqewqewq"});
    	 
    	 k(1156151,5456415,541541514,515616);
    	 k('a',213245,"wqewerr",656l,0x21312,3.22d,254l);
    	 k();
    }
    
    public static void f(String...args)
    {
    	for(String s : args)
    		System.out.println(s+" ");
    	System.out.println();
    }
    
    public static void k(Object...args)
    {
    	for(Object obj:args)
    		System.out.println(obj +" ");
    	System.out.println();
    }   
}



