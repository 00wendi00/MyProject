/**
 * �ļ�����Shapes.java
 * ��Ŀ-����JAVA���˼�� - �ڰ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-10
 */
package �ڰ���;
import java.util.Random;
/**
 * @author ���ĵ�
 * ������Shapes
 * ��˵����   ��ϰ2��3,4.  ��δ�������  upcasting
 */
public class Shapes
{
   private static RandomShapeGenerator gen = new RandomShapeGenerator(); 
   public static void main(String args[])
   {
        Shape[] s = new Shape[13];
        for(int i = 0; i<s.length;i++)
        	s[i] = gen.next();
        for(Shape shp:s)   //    ��ǿ��ѭ�� ��Ҫ����������,���� s[i]
        	{
        	   shp.draw();
        	   shp.erase();
        	   shp.print123456(); // ���Ǻ�ֱ�ӵ�������ķ�����û���� �͵��ø���ġ�
        	}
            
   }
}

class Shape
{
    public void draw(){}
    public void erase(){}
    public void print123456()
    {
    	System.out.println("����� ~~~~~~~~~~");
    }
}
class Circle extends Shape
{
	 @Override public void draw()   //  @Override ��ǣ� ��ʾҪ���¸��෽������ֹƴд����
     {
    	 System.out.println("Circle.draw()");    	 
     }
     public void erase()
     {
    	 System.out.println("Circle.erase()");
     }
     public void print123456()
     {
     	System.out.println("����� ~~~~~~~~~~11111111");
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
    	System.out.println("����� ~~~~~~~~~~2222222222");
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

