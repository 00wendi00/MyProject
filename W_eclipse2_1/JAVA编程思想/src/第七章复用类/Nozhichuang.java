/**
 * 文件名：Nozhichuang.java
 * 项目-包：JAVA编程思想 - 第七章复用类
 * 作者：张文迪
 * 创建日期：2014-9-9
 */
package 第七章复用类;

/**
 * @author 张文迪
 * 类名：Nozhichuang
 * 类说明：练习15.  不同包的 非子类 也可以调用 基类的    protected 
 */
public class Nozhichuang extends Ohmygad
{
     public static void main(String args[])
     {
    	 Nozhichuang nozhichuang = new Nozhichuang();
    	 nozhichuang.HaHa101();
     }
}

class Ohmygad 
{
    protected void HaHa101()
    {
    	System.out.println("调用了!!");
    }
}
