/**
 * 文件名：ToyTest1.java
 * 项目-包：JAVA编程思想 - 第十四章类型信息
 * 作者：张文迪
 * 创建日期：2014-10-17
 */
package 第十四章类型信息;

/**
 * @author 张文迪
 * 类名：ToyTest1
 * 类说明：练习1,2 ~~~
 */

import static net.mindview.util.Print.*;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
interface Haha{}

class Toy 
{
	//Toy() {}
	Toy(int i) {}
}

class FancyToy extends Toy implements Haha, HasBatteries, Waterproof, Shoots
{
		FancyToy() { super(1); }
}

public class ToyTest1 
{
	static void printInfo(Class cc) 
	{
		print("Class name: " + cc.getName() +
			" is interface? [" + cc.isInterface() + "]");
		print("Simple name: " + cc.getSimpleName());
		print("Canonical name: " + cc.getCanonicalName());
	}
	public static void main(String[] args) 
	{
		Class c = null;
		try {
			c = Class.forName("typeinfo.toys.FancyToy");
		} catch(ClassNotFoundException e) {
			print("Can't find FancyToy");
			System.exit(1);
		}
		printInfo(c);  
		for(Class face : c.getInterfaces())
			printInfo(face);
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			// Requires default constructor in order to
			// create a super or Toy object:
			obj = up.newInstance();
		} catch(InstantiationException e) {
			print("Cannot instantiate");
			System.exit(1);
		} catch(IllegalAccessException i) {
			print("Cannot access");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}
}