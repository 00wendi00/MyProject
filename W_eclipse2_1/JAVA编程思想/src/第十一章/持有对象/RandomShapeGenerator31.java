/**
 * �ļ�����RandomShapeGenerator31.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-9
 */
package ��ʮһ��.���ж���;

import java.util.Iterator;
import java.util.Random;

/**
 * @author ���ĵ�
 * ������RandomShapeGenerator31
 * ��˵���� ������Ҳ������ ~~~~~~~~~
 */
public class RandomShapeGenerator31 implements Iterable<Shape> {
	private Random rand = new Random();
	public Shape make() {		
		switch(rand.nextInt(3)) {
			default:
			case 0: return new Circle();
			case 1: return new Square();
			case 2: return new Triangle();
		}
	}
	private Shape[] shapes;
	RandomShapeGenerator31(int n) {
		shapes = new Shape[n];
		for(int i = 0; i < n; i++)
			shapes[i] = make();
				 
	}
	public Iterator<Shape> iterator() 
	{
		return new Iterator<Shape>() 
		{
			private int index = 0;
			public boolean hasNext() {
				return index < shapes.length;
			}
			public Shape next() {
				return shapes[index++];
			}
			public void remove() {
				throw new UnsupportedOperationException();
			}			
		};
	}
	public static void main(String[] args) {
		RandomShapeGenerator31 rsg = new RandomShapeGenerator31(20);
		for(Shape s : rsg)
			System.out.println(s);
	}
}


class Shape {
		public void draw() {}
		public void erase() {}
	 public String toString() { return "Shape"; }
	 }
class Circle extends Shape {
		 public void draw() { System.out.println("Circle.draw()"); }
	 public void erase() { System.out.println("Circle.erase()"); }
 public void amend() { System.out.println("Circle.amend()"); }
	 public String toString() { return "Circle"; }
	}
class Square extends Shape {
		 public void draw() { System.out.println("Square.draw()"); }
		 public void erase() { System.out.println("Square.erase()"); }
	 public void amend() { System.out.println("Square.amend()"); }
		public String toString() { return "Square"; }
	}
class Triangle extends Shape {
		public void draw() { System.out.println("Triangle.draw()"); }
	 public void erase() { System.out.println("Triangle.erase()"); }
		 public void amend() { System.out.println("Triangle.amend()"); }
	public String toString() { return "Triangle"; }
	}
