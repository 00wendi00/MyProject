/**
 * 文件名：CADSystem16.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：CADSystem16
 * 类说明：
 */

class Shape 
{
	Shape(int i) { System.out.println("Shape constructor"); }
	void dispose() { System.out.println("Shape dispose"); }		
}

class Circle extends Shape 
{
	Circle(int i) 
	{
		super(i);
		System.out.println("Drawing Circle");
	}
	void Dispose() 
	{
		System.out.println("Erasing circle");
		super.dispose();
	}
}

class Triangle extends Shape
{
	Triangle(int i) 
	{
		super(i);
		System.out.println("Drawing Triangle");
	}	
	void dipsose() 
	{ 
		System.out.println("Erasing Triangle"); 
		super.dispose();	
	}
}

class Line extends Shape 
{
	private int start, end;
	Line(int start, int end) 
	{
		super(start);
		this.start = start;
		this.end = end;
		System.out.println("Drawing Line: " + start + ", " + end); 
	}
	void dispose() 
	{
		System.out.println("Erasing Line: " + start + ", " + end);
		super.dispose();
	}
}

public class CADSystem16 extends Shape 
{
	private Circle c;
	private Triangle t;
	private Line[] lines = new Line[3];
	public CADSystem16(int i) 
	{
		super(i + 1);
		for(int j = 0; j < lines.length; j++)
			lines[j] = new Line(j, j*j);
		c = new Circle(1);
		t = new Triangle(1);
		System.out.println("Combined constructor");
	}
	public void dispose() 
	{
		System.out.println("CADSystem.dispose()");
		// The order of cleanup is the reverse
		// of the order of initialization
		t.dispose();
		c.dispose();
		for(int i = lines.length - 1; i >= 0; i--)
			lines[i].dispose();
		super.dispose();
	}
	public static void main(String[] args) 
	{
		CADSystem16 x = new CADSystem16(47);
		try 
		{
			System.out.println("Returning from try block");
			return;
			// unreachable statement:
			// print("You can't see this");
			// but finally block will still execute:
		} 
		finally 
		{
			x.dispose();
		} 
	}	
}