/**
 * 文件名：Cycle.java
 * 项目-包：JAVA编程思想 - 第八章
 * 作者：张文迪
 * 创建日期：2014-9-9
 */
package 第八章;
/**
 * @author 张文迪
 * 类名：Cycle
 * 类说明：      练习 1,5，17
 */
public class Cycle
{

	public int wheels(int i)
	{
		System.out.println(i+"轮");
		return i;
	}
	protected void Ride(int i)
	{		
		this.wheels(i);
		System.out.println("Ride");		
	}
	public String toString(Cycle i)
	{
		return ""+i;
	}
    public static void main(String args[])
    {
    	Unicycle unicycle = new Unicycle();
    	Bicycle bicycle = new Bicycle();
    	Tricycle tricycle = new Tricycle();
    	Cycle cycle = new Unicycle(); // upcasting

    	unicycle.Ride(bicycle);
    	bicycle.Ride(tricycle); 	   	
    	tricycle.Ride(cycle);
    	tricycle.Ride(2);
    	bicycle.Ride(3);
    	unicycle.Ride(4);  
    	cycle.Ride(3);
    	    	
    	System.out.println();
    	
    	//练习17
    	Cycle cycle01 = unicycle;
    	Cycle cycle02 = bicycle;
    	Cycle cycle03 = tricycle;
    	unicycle.balance();
    	bicycle.balance();
    	//tricycle.balance();  
    	
    	//cycle01.balance();
    	//cycle02.balance();
    	//cycle03.balance();
    	
    	//((Unicycle)cycle02).balance();   显然  这样是不行 的  
    	
        ((Unicycle)cycle01).balance();
        ((Bicycle)cycle02).balance();
        //((Tricycle)cycle03).balance();
        
    	
    }
}
class Unicycle extends Cycle
{
     protected void Ride(Cycle i)
    {
    	System.out.println("Ride11111111+Unicycle"+i);
    }
    public void balance()
    {
    	System.out.println("balance");
    }
}
class Bicycle extends Cycle
{
	protected void Ride(Cycle i)
    {
    	System.out.println("Ride22222222+Bicycle"+i);
    }
	public void balance()
    {
	    System.out.println("balance");
	}
}
class Tricycle extends Cycle
{
	protected void Ride(Cycle i)
    {
    	System.out.println("Ride33333333+Tricycle"+i);
    }
}