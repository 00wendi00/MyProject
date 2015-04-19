/**
 * �ļ�����Shapes3.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����������Ϣ
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-18
 */
package ��ʮ����������Ϣ;

/**
 * @author ���ĵ�
 * ������Shapes3
 * ��˵������ϰ3����ʾ������ת��~   ��ϰ5��instanceof
 */
import java.util.*;

abstract class Shape {
	void draw() { System.out.println(this + ".draw()"); }
	void rotate() {System.out.println(this+"��ת����");}
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
