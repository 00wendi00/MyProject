/**
 * 文件名：TwoFlower.java
 * 项目-包：JAVA编程思想 - 第五章初始化与清理
 * 作者：张文迪
 * 创建日期：2014-9-5
 */
package 第五章初始化与清理;

/**
 * @author 张文迪
 * 类名：TwoFlower
 * 类说明：练习9. this（）调用。
 */
public class TwoFlower
{
   public static void main(String args[])
   {
	   new Flower();
   }
}

class Flower
{
    Flower()
    {
    	this(5, "你好，哈哈！");
    	System.out.println("ok1");
    }
    Flower(int i,String s)
    {
    	this("你好,","好的");
    	System.out.println("ok2"+i+s);
    }
    Flower(String a, String b)
    {
    	System.out.println("ok3"+a+b);
    }
}
