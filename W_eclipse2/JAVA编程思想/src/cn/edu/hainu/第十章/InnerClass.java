/**
 * 文件名：InnerClass.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第十章
 * 作者：张文迪
 * 创建日期：2014-9-25
 */
package cn.edu.hainu.第十章;
/**
 * @author 张文迪
 * 类名：InnerClass
 * 类说明：练习9,10,11  内部类定义在不同的 地方~~~private修饰过的内部类被完全隐藏了！
 */
public class InnerClass
{ 
    public Class11 haha0(boolean b)
    {
    	if(b)
    	{
    		class HaoDe123 implements Class11
    		{
				public void heihei(String s)
				{
					System.out.println(s+"~~~~~~~~~~~");
				}   			
    		}
    		return new HaoDe123();
    	}
    	class HaoDe implements Class11
    	{
			public void heihei(String s)
			{
				System.out.println(s);
			}  		
    	}
		return new HaoDe();
    }
    private class HaoDe12345 implements Class11
    {
		public void heihei(String s)
		{
			System.out.println("private 类"+s);
		}    	
    }
    public Class11 haha12345()
    {
    	return new HaoDe12345();
    }
    public static void main(String args[])
    {
    	InnerClass innerClass = new InnerClass();
    	innerClass.haha0(false).heihei("额！！！！！！！");
    	innerClass.haha0(true).heihei("额000000");
    	
    	Class11 class11 = innerClass.haha12345();
    	//((haha12345)class11).heihei(" 1");   //练习11：private修饰过的内部类被完全隐藏了！   	
    }
}
interface Class11
{
	public void heihei(String s);
}
