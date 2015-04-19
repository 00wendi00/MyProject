/**
 * 文件名：TestBefore.java
 * 项目-包：JAVA编程思想 - 第五章初始化与清理
 * 作者：张文迪
 * 创建日期：2014-9-6
 */
package 第五章初始化与清理;

/**
 * @author 张文迪
 * 类名：TestBefore
 * 类说明：练习14.  静态方法在使用之前就完成了初始化。
 */
public class TestBefore
{
     public static void main(String args[])
     {
    	 YunYan yunYan = new YunYan();
    	 yunYan.Haha();
     }
     
}

class YunYan
{
	 static String nimabi = "nimabi000000000000";
     static  
     {
    	 String nima = "14111111111";
    	 System.out.println(nima);
     }
     static void Haha()
     {
    	 System.out.println(nimabi);
    	 
     }
}
