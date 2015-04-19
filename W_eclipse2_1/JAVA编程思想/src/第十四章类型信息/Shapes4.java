/**
 * 文件名：Shapes4.java
 * 项目-包：JAVA编程思想 - 第十四章类型信息
 * 作者：张文迪
 * 创建日期：2014-10-18
 */
package 第十四章类型信息;

/**
 * @author 张文迪
 * 类名：Shapes4
 * 类说明：练习4~~~
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
