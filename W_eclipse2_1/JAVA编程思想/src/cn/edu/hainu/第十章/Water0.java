/**
 * 文件名：Water0.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第十章
 * 作者：张文迪
 * 创建日期：2014-9-25
 */
package cn.edu.hainu.第十章;

/**
 * @author 张文迪
 * 类名：Water0
 * 类说明：   练习 7，12 ：在类中创建其内部类对象！    练习8： 外围类能访问到内部类的private 域  ！！！+匿名内部类
 */
public class Water0
{
     private int i = 0;
     class Water1
     {
    	 private int  k = 4;
    	 public int hahaWater1()
    	 {   		 
    		 i+=3;
    		 hahaWater0();
    		 return i;
    	 }
    	 public void Show1()
    	 {
    		 System.out.println(k);
    	 }
     }
     int k = new Water1().k ;//!!!!!!!!!!!!!!!!!!!!!!
     private void hahaWater0()
     {
    	 System.out.println(i);
    	 System.out.println(k);
     }
     public void haha0000()
     {
    	 Water1 water1 = new Water1();
    	 water1.hahaWater1();
    	 water1.Show1();
     }
     
     //匿名内部类
     public Water2 water2(final int i)
     {
    	 return new Water2(){
    		 private int nima;
    		 {
    			 nima = i;
    			 System.out.println(nima);
    		 }
			public void See()
			{
				System.out.println("See   @#$%^&*(");
			}
    	 };
     }
   
     public static void main(String args[])
     {
    	 Water0 water0 = new Water0();
    	 water0.haha0000();
    	 
    	 Water2 water2 = water0.water2(9);
     }
}
interface Water2
{
	public void See();
}
