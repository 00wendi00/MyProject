/**
 * 文件名：Holder2.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-20
 */
package 第十五章泛型;


/**
 * @author 张文迪
 * 类名：Holder2
 * 类说明：练习2~~~
 */
import typeinfo.pets.*;

class Robot 
{
	private String name;
	public Robot(String name) { this.name = name; }
	public String toString() { return name;}
}

public class HolderEx2<T> 
{
	private T x, y, z;
	public HolderEx2(T x, T y, T z) 
	{ 
		this.x = x;
		this.y = y;
		this.z = z;
	 }
	public void setX(T x) { this.x = x; }
	public void setY(T y) { this.y = y; }
	public void setZ(T z) { this.z = z; }
	public T getX() { return x; }
	public T getY() { return y; }
	public T getZ() { return z; }
	public String toString() {return x + ", " + y + ", " + z;}
	public static void main(String[] args) {
		Robot a = new Robot("bot1");
		Robot b = new Robot("bot2");
		Robot c = new Robot("bot3");
		HolderEx2<Robot> hEx2 = 
			new HolderEx2<Robot>(a, b, c);
		System.out.println("Holding: " + hEx2);
	}
}
