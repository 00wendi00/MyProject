/**
 * 文件名：Car11.java
 * 项目-包：JAVA编程思想 - 第七章复用类
 * 作者：张文迪
 * 创建日期：2014-9-8
 */
package 第七章复用类;

/**
 * @author 张文迪
 * 类名：Car11
 * 类说明：练习14
 */
public class Car11
{
	public Engine11 engine11 = new Engine11();
	public Wheel11[] wheel11 = new Wheel11[4];
	public Door11 
	    leftDoor11 = new Door11(),
	    rightDoor11  = new Door11();
	public Car11()
	{
		for(int i=0;i<4;i++)
			wheel11[i] = new Wheel11();
	}
	public static void main(String args[])
    {
    	Car11 car11 = new Car11();
    	car11.leftDoor11.window11.roolup();
    	car11.wheel11[0].inflate(75);
    	car11.engine11.server();
    }
}
class Engine11
{	
	public void start(){}
	public void rev(){}
	public void stop(){}
	public void server()
	{
		System.out.println("server!");
	}
}
class Wheel11
{
	public void inflate(int psi){}
}
class Window11
{
	public void roolup(){}
	public void rooldown(){}
}
class Door11
{
	public Window11 window11 = new Window11();
	public void open(){}
	public void close(){}
}
