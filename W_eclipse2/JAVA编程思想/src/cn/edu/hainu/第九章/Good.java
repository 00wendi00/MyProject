/**
 * 文件名：Good.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第九章
 * 作者：张文迪
 * 创建日期：2014-9-15
 */
package cn.edu.hainu.第九章;



/**
 * @author 张文迪
 * 类名：Good
 * 类说明：练习 3 
 */
public class Good
{
   public static void main(String args[])
   {
	   GoodMorning goodMorning = new GoodMorning();
	   goodMorning.print();
	   
	   
	   
   }
}

abstract class GoodDay
{
    abstract void print(); 	
}

class GoodMorning extends GoodDay
{
	int k = 5;
	void print()
	{
		System.out.println(k);		
	}
    
}

