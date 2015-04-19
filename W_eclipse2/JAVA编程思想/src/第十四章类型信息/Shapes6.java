/**
 * 文件名：Shapes6.java
 * 项目-包：JAVA编程思想 - 第十四章类型信息
 * 作者：张文迪
 * 创建日期：2014-10-18
 */
package 第十四章类型信息;

/**
 * @author 张文迪
 * 类名：Shapes6
 * 类说明：(flag ? "H" : "Unh")~~~ 练习6~“表示”。
 */
import java.util.Arrays;
import java.util.List;

class Circle6 extends Shape {
	boolean flag = false;
	public String toString() { 
		return (flag ? "H" : "Unh") + "ighlighted " + "Circle"; 
	}
}

class Square6 extends Shape {
	boolean flag = false;
	public String toString() { 
		return (flag ? "H" : "Unh") + "ighlighted " + "Square"; 
	}
}

class Triangle6 extends Shape {
	boolean flag = false;
	public String toString() { 
		return (flag ? "H" : "Unh") + "ighlighted " + "Triangle"; 
	}
}

public class Shapes6 {
	public static void setFlag(Shape s) {
			if(s instanceof Triangle6)
				((Triangle6)s).flag = true; 
		}			
	public static void main(String[] args) {
		// upcasting to Shape:
		List<Shape> shapeList = Arrays.asList(
			new Circle6(), new Square6(), new Triangle6()
		);
		for(Shape shape : shapeList) {
			setFlag(shape);
			System.out.println(shape);
		}
	}
}
