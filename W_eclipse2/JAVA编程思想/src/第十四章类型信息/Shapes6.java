/**
 * �ļ�����Shapes6.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����������Ϣ
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-18
 */
package ��ʮ����������Ϣ;

/**
 * @author ���ĵ�
 * ������Shapes6
 * ��˵����(flag ? "H" : "Unh")~~~ ��ϰ6~����ʾ����
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
