/**
 * 文件名：Dinner.java
 * 项目-包：JAVA编程思想 - 第七章复用类
 * 作者：张文迪
 * 创建日期：2014-9-9
 */
package 第七章复用类;

/**
 * @author 张文迪
 * 类名：Dinner
 * 类说明：练习 21 。final 方法不能被覆盖
 */

public class Dinner extends Meals0
{
    public static void main(String args[])
    {
    	Dinner dinner = new Dinner();
    	dinner.Eat();
    	dinner.Eat(0);
    }
    public void Eat(int i)
    {
    	System.out.println("吃"+i);
    }
}

class Meals0
{
    public final void Eat()
    {
        System.out.println("吃饭");
    }
}