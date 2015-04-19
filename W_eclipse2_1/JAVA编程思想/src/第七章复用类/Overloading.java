/**
 * 文件名：Overloading.java
 * 项目-包：JAVA编程思想 - 第七章复用类
 * 作者：张文迪
 * 创建日期：2014-9-8
 */
package 第七章复用类;

/**
 * @author 张文迪
 * 类名：Overloading
 * 类说明：
 */
public class Overloading extends BigRain123
{
    public static void main(String args[])
    {
    	Overloading overloading = new Overloading();
    	overloading.overloadingMethod();
    	overloading.sterilize();
    }
    public void overloadingMethod()
    {
    	super.overloadingMethod(); // output: 被重写的方法
    	System.out.println("好的，覆盖了");
    }
    public void sterilize()
    {
    	System.out.println("额！！！！！");
    }
}
