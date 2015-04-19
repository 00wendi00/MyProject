/**
 * 文件名：甲壳虫.java
 * 项目-包：JAVA编程思想 - 第七章复用类
 * 作者：张文迪
 * 创建日期：2014-9-9
 */
package 第七章复用类;

/**
 * @author 张文迪
 * 类名：甲壳虫
 * 类说明：练习23,24.  继承中的      编译顺序 。  
 */
class Insect
{
    private int i = 9;
    protected int j;
    Insect()
    {
    	System.out.println("i="+i+",j="+j);
    	j = 39;
    }                                  //55   按顺序，先基类的构造方法
    private static int x1 = printInit("static Insect.x1 initialized");//111
    static int printInit(String s)
    {
    	System.out.println(s);
    	return 47;
    }
}

class Beetle extends Insect
{
    private int k = printInit("Beetle.k initialized");//66构造方法之前，先   非静态成员变量
    Beetle()
    {
    	System.out.println("K="+k);
    	System.out.println("j="+j);
    	
    }                         //777
    private static int x2 =printInit("static Beetle.x2 initialized");//222
}

public class 甲壳虫  extends Beetle
{
	private int h = printInit("Beetle.h initialized");//8888
	甲壳虫()
	{
		System.out.println("h="+h);   //999
	}
	private static int x3 =printInit("static Beetle.x3 initialized");//333
	public static void main(String args[])
	{
		System.out.println("甲壳虫 constructor");//444       编译    静态的 成员变量 之后
		甲壳虫  jkc = new 甲壳虫();
	}
}

