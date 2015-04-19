/**
 * 文件名：TestFinalize.java
 * 项目-包：JAVA编程思想 - 第五章初始化与清理
 * 作者：张文迪
 * 创建日期：2014-9-5
 */
package 第五章初始化与清理;

import 第四章.Break;

/**
 * @author 张文迪
 * 类名：TestFinalize
 * 类说明： 练习 10,11.
 */
public class TestFinalize
{
    public static void main(String args[])
    {
    	Tfinalize finalize = new Tfinalize(true);
    	finalize.checked(); 
    	new Tfinalize(true);
    	//finalize.finalize();//调用才清理。
    }
}

class Tfinalize
{
	boolean check =false;
	Tfinalize(boolean k)
	{   
		check = k;		
		System.out.println("测试一下！！");		
	}
	void checked()
	{
		check = true;
	}
    protected void finalize()
    {
    	if(check)
    	{
    		System.out.println(" 清理了 ！");
    		return;
    	}
    }
}
