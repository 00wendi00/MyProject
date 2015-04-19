/**
 * 文件名：Frog17.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：Frog17
 * 类说明：
 */
class Characteristic 
{
	private String s;
	Characteristic(String s) 
	{
		this.s = s;
		System.out.println("Creating Characteristic " + s);
	}
	protected void dispose() 
	{
		System.out.println("disposing Characteristic " + s);
	}
}

class Description
{
	private String s;
	Description(String s) 
	{
		this.s = s;
		System.out.println("Creating Description " + s);
	}
	protected void dispose() 
	{
		System.out.println("disposing Description " + s);
	}
}

class LivingCreature 
{
	private Characteristic p = new Characteristic("is alive");
	private Description t = new Description("Basic Living Creature");
	LivingCreature() 
	{
		System.out.println("LivingCreature()");
	}		
	protected void dispose() 
	{
		System.out.println("LivingCreature dispose");
		t.dispose();
		p.dispose();
	}
}

class Animal extends LivingCreature
{
	private Characteristic p = new Characteristic("has heart");
	private Description t = new Description("Animal not Vegetable");
	Animal() { System.out.println("Animal()"); }
	protected void dispose() 
	{
		System.out.println("Animal dispose");
		t.dispose();
		p.dispose();
		super.dispose();
	}
}

class Amphibian extends Animal 
{
	private Characteristic p = new Characteristic("can live in water");
	private Description t = new Description("Both water and land");
	Amphibian() { System.out.println("Amphibian()"); }
	protected void dispose() 
	{
		System.out.println("Amphibian dispose");
		t.dispose();
		p.dispose();
		super.dispose();
	}
}

public class Frog17 extends Amphibian 
{
	private Characteristic p = new Characteristic("Croaks");
	private Description t = new Description("Eats Bugs");
	public Frog17() { System.out.println("Frog17()"); }
	public static void jump() { System.out.println("frog jumps"); }
	protected void dispose() 
	{
		System.out.println("Frog17 dispose");
		t.dispose();
		p.dispose();
		super.dispose();
	}
	public static void main(String[] args) 
	{
		Frog17 frog = new Frog17();
		try 
		{
			frog.jump();
			System.out.println("Returning from try-finally");
			return;			
		} 
		finally 
		{
			System.out.println("Bye!");
			frog.dispose();
		}
	}
}