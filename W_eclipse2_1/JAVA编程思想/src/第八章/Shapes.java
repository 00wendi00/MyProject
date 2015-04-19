/**
 * 文件名：Shapes.java
 * 项目-包：JAVA编程思想 - 第八章
 * 作者：张文迪
 * 创建日期：2014-9-10
 */
package 第八章;
import java.util.Random;
/**
 * @author 张文迪
 * 类名：Shapes
 * 类说明：   练习2，3,4.  如何创建，和  upcasting
 */
public class Shapes
{
   private static RandomShapeGenerator gen = new RandomShapeGenerator(); 
   public static void main(String args[])
   {
        Shape[] s = new Shape[13];
        for(int i = 0; i<s.length;i++)
        	s[i] = gen.next();
        for(Shape shp:s)   //    增强型循环 主要用来做遍历,遍历 s[i]
        	{
        	   shp.draw();
        	   shp.erase();
        	   shp.print123456(); // 覆盖后直接调用子类的方法，没覆盖 就调用父类的。
        	}
            
   }
}

class Shape
{
    public void draw(){}
    public void erase(){}
    public void print123456()
    {
    	System.out.println("输出了 ~~~~~~~~~~");
    }
}
class Circle extends Shape
{
	 @Override public void draw()   //  @Override 标记： 表示要重新父类方法，防止拼写错误。
     {
    	 System.out.println("Circle.draw()");    	 
     }
     public void erase()
     {
    	 System.out.println("Circle.erase()");
     }
     public void print123456()
     {
     	System.out.println("输出了 ~~~~~~~~~~11111111");
     }
}
class Square extends Shape
{
     public void draw()
     {
    	 System.out.println("Square.draw()");    	 
     }
     public void erase()
     {
    	 System.out.println("Square.erase()");
     } 
}
class Triangle extends Shape
{
     public void draw()
     {
    	 System.out.println("Triangle.draw()");
    	
     }
     public void erase()
     {
    	 System.out.println("Triangle.erase()");
     }  
}
class Diamond extends Shape
{
	public void draw()
    {
   	 System.out.println("Diamond.draw()");    	 
    }
    public void erase()
    {
   	 System.out.println("Diamond.erase()");
    }
    public void print123456()
    {
    	System.out.println("输出了 ~~~~~~~~~~2222222222");
    }	
}
class RandomShapeGenerator
{
    private Random rand = new Random(47);
    public Shape next()
    {
    	switch (rand.nextInt(4))
		{
		default:
		case 0:	return new Square();					
		case 1: return new Triangle();
		case 2: return new Circle();
		case 3: return new Diamond();    // upcasting
		}
    }
}

