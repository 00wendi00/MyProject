/**
 * �ļ�����Shapes4.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����������Ϣ
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-18
 */
package ��ʮ����������Ϣ;

/**
 * @author ���ĵ�
 * ������Shapes4
 * ��˵������ϰ4~~~
 */
import java.util.Arrays;
import java.util.List;


public class Shapes4 {
	public static void main(String[] args) {
		// upcasting to Shape:
		List<Shape> shapeList = Arrays.asList(
			new Circle(), new Square(), new Triangle(), new Rhomboid()
		);
		// downcasting back to specific shape:
		for(Shape shape : shapeList)
			shape.draw();
		Rhomboid r = new Rhomboid();
		((Shape)r).draw();
		// inconvertible types:
		//((Circle)r).draw();
		System.out.println();
		Rhomboid rp = new Rhomboid();
		Shape s = (Shape)rp;
		s.draw();
		
		if(s instanceof Circle) 
			((Circle)s).draw();
		else
			System.out.println("(Shape)r is not a Circle");		
	}
}
