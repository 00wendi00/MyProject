/**
 * 文件名：Incrementable.java
 * 项目-包：JAVA编程思想 - 第一二章
 * 作者：张文迪
 * 创建日期：2014-9-2
 */
package 第一二章;

/**
 * @author 张文迪
 * 类名：Incrementable
 * 类说明：练习7,8。类中某个特定的 static域只有一个实例
 */
 class Incrementable
{
	 
    static void increment()
    {
    	StaticTest.i++;
    }
    
    public static void main(String args[])
    {
    	StaticTest st1 = new StaticTest();
    	StaticTest st2 = new StaticTest(); 	
    	StaticTest st3 = new StaticTest();
    	Incrementable sf1 = new Incrementable();
    	Incrementable sf2 = new Incrementable();
    	Incrementable sf3 = new Incrementable();
    	
        sf1.increment();  //48
        sf2.increment();    //49，      练习8：sf1 sf2 sf3 其实是一个实例。
        sf3.increment();    //50，无论创建这个类的多少个对象，这个类中某个特定的 static域只有一个实例。
        sf1.increment();   //51
        
    	Incrementable.increment();
    	
    	System.out.println(st1.i++);
    	System.out.println(st1.i++);
    	System.out.println(st2.i++);
    	System.out.println(st3.i++);
    	
    }
}
 
 
class StaticTest
{
	static int i = 47;
}
