/**
 * 文件名：Ex18.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第九章
 * 作者：张文迪
 * 创建日期：2014-9-24
 */
package cn.edu.hainu.第九章;

/**
 * @author 张文迪
 * 类名：Ex18
 * 类说明：
 */
public class Ex18
{
	public static void playCycle(CycleFactory factory)
	{
		Cycle c = factory.getCycle();
		while(c.move());
	}
    public static void main(String args[])
    {
    	playCycle(new UnicycleFactory());
    	playCycle(new BicycleFactory());
    	playCycle(new TricycleFactory());
    }
}
interface Cycle{boolean move();}
interface CycleFactory{Cycle getCycle();}
class Unicycle implements Cycle
{
    private int moves = 4;
	public boolean move()
	{
		System.out.println("UniCycle moves "+moves);
		return --moves != 0 ;
	}	
}
class UnicycleFactory implements CycleFactory
{
	public Cycle getCycle()
	{
		return new Unicycle();
	}	
}


class Bicycle implements Cycle
{
    private int moves = 2 ;
	public boolean move()
	{
		System.out.println("Bicycle moves " +moves );
		return --moves != 0;
	}	
}
class BicycleFactory implements CycleFactory
{
	public Cycle getCycle()
	{
		return new Bicycle();
	}	
}


class Tricycle implements Cycle
{
	private int moves = 3;
	public boolean move()
	{	
		System.out.println("Tricycle moves "+moves);
		return --moves != 0;
	}	
}
class TricycleFactory implements CycleFactory
{
	public Cycle getCycle()
	{
		return new Tricycle();
	}
}