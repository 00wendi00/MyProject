/**
 * 文件名：Rain123.java
 * 项目-包：JAVA编程思想 - 第七章复用类
 * 作者：张文迪
 * 创建日期：2014-9-8
 */
package 第七章复用类;

/**
 * @author 张文迪
 * 类名：Rain123
 * 类说明：练习1  ： 惰性初始化
 */
public class Rain123
{
	 private static BigRain123 bigRain;
	 public Rain123()
	 {
		 bigRain = new BigRain123();   //实例初始化   ~~和惰性初始化！！！！！！！！！！
	 }
	 public String toString()
	 {
		 return
		    "bigRain="+bigRain;  //将 BigRain 类型转化为String类型
	 }
     public static void main(String args[])
     {
    	 Rain123 rain = new Rain123();
    	 System.out.println(rain);
    	 
     }
}

class BigRain123    // Overloading 的父类。
{
	private String s;
    BigRain123()
    {
    	System.out.println("BigRain123()"+"  父类对象也被创建了 ");
    	s = "尼玛，好的雨";
    }
    public String toString()
    {
    	return s;
    }
    public void overloadingMethod()
    {
    	System.out.println("方法重写");
    }
}
