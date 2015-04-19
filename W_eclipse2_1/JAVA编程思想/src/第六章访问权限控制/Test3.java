/**
 * 文件名：Test3.java
 * 项目-包：JAVA编程思想 - 第六章访问权限控制
 * 作者：张文迪
 * 创建日期：2014-9-7
 */
package 第六章访问权限控制;

import debug.Hahaha123456;//   !!!!!!!!!!!!!

/**
 * @author 张文迪
 * 类名：Test3
 * 类说明：练习3 ： import 改变行为。    
 * ++++ 练习9 ：debug 包中的 Hahaha123456 类应为public。 不然不能为其他包中的类  创建对象。
 */
public class Test3
{
    public static void main(String args[])
    {
    	Hahaha123456 haha132456 = new Hahaha123456();
    	haha132456.debug();
    	
    	Class4444 class4444 = new Class4444();
    	class4444.Haha111();
    	class4444.Haha222();
    	class4444.Haha333();
    	//class4444.Haha444();
    }
}
