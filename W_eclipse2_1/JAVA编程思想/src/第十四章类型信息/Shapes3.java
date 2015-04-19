/**
 * 文件名：Shapes3.java
 * 项目-包：JAVA编程思想 - 第十四章类型信息
 * 作者：张文迪
 * 创建日期：2014-10-18
 */
package 第十四章类型信息;

/**
 * @author 张文迪
 * 类名：Shapes3
 * 类说明：练习3：显示的向下转型~   练习5：instanceof
 */
import java.util.*;

abstract class Shape {
	void draw() { System.out.println(this + ".draw()"); }
	void rotate() {System.out.println(this+"旋转！！");}
	abstract public String toString();
}

class Circle extends Shape {
	public String toString() { return "Circle"; }
}

class Square extends Shape {
	public String toString() { return "Square"; }
}

class Triangle extends Shape {
	public String toString() { return "Triangle"; }
}

class Rhomboid extends Shape {
	public String toString() { return "Rhomboid"; }
}

public class Shapes3 {
	public static void main(String[] args) {
		// upcasting to Shape:
		List<Shape> shapeList = Arrays.asList(
			new Circle(), new Square(), new Triangle(), new Rhomboid()
		);
		// downcasting back to specific shape:
		for(Shape shape : shapeList)
			{
				shape.draw();
				if(!(shape instanceof Circle))
					shape.rotate();
			}
		Rhomboid r = new Rhomboid();
		((Shape)r).draw();
		// inconvertible types:
		//((Circle)r).draw();
		Shape rp = new Rhomboid();
		rp.draw();
	}
}
