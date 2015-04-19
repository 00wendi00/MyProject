/**
 * 文件名：Ligth000.java
 * 项目-包：JAVA编程思想 - 第八章
 * 作者：张文迪
 * 创建日期：2014-9-10
 */
package 第八章;

/**
 * @author 张文迪
 * 类名：Ligth000
 * 类说明：练习10 。//父类 引用指向子类对象 。子类对象调用  已经覆盖了的 方法。
 */
public class Ligth000
{
    public static void main(String args[])
    {
    	Ligth000 ligth000 = new GoodLigth000();
    	ligth000.Method1();//父类 引用指向子类对象 。子类对象调用  已经覆盖了的 方法。
    }
    public void Method1()
    {
    	Method2();
    }
    public void Method2()
    {
    	System.out.println("额！！！");
    }
}
class GoodLigth000 extends Ligth000
{
	public void Method2()
    {
    	System.out.println("哈哈！！！");
    }
}
