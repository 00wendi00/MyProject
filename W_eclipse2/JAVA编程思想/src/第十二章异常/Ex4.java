/**
 * 文件名：Ex4.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

import cn.edu.hainu.第十章.sunShine;

/**
 * @author 张文迪
 * 类名：Ex4
 * 类说明：练习4，28~~~对于RuntimeException及其子类，可以直接抛出，而不用进行异常处理，如try,catch或者throws。
 */
public class Ex4 
{
	public static void f() throws My1Exception 
	{
		System.out.println("f()");
		throw new My1Exception("Ouch from f()");// 这个参数~   s  
	}
	public static void main(String[] args) 
	{
		f();
		/*try 
		{
			f();	
		} 
		catch(My1Exception e) 
		{
			System.err.println("Caught Exception4");
			e.printStackTrace();
			e.showS();
		} 
		*/
	}	
}
class My1Exception extends RuntimeException
{
	private String s ;
	My1Exception() {}
	My1Exception(String s)
	{
		super(s);
		System.out.println("Exception4~~~~~~~~");
		this.s = s;
	}
	protected void showS() { 
		System.out.println("Message from Exception4: " + s);
	}
}