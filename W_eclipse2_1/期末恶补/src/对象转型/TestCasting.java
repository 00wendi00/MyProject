/**
 * 文件名：TestCasting.java
 * 项目-包：期末恶补 - 对象转型
 * 作者：张文迪
 * 创建日期：2014-6-23
 */
package 对象转型;

/**
 * @author 张文迪
 * 类名：TestCasting
 * 类说明：
 */
/**
 * 文件名：Animal.java
 * 项目-包：oobjectPro - castingPack
 * 作者：胡祝华
 * 创建日期：2011-10-23
 */


/**
 * @author 胡祝华
 * 类名：Animal
 * 类说明：对象转型
 */

class Animal
{
	
	public String name;
	
	public Animal(String name)
	{
		this.name = name;
	}
}

class Dog extends Animal
{
	public String furColor;

	public Dog(String name, String furColor)
	{
		super(name);
		this.furColor = furColor;
	}
}

class Cat extends Animal
{
	public String eyeColor;

	public Cat(String name, String eyeColor)
	{
		super(name);
		this.eyeColor = eyeColor;
	}
}

public class TestCasting
{
	public static void main(String[] args)
	{
		Animal a = new Animal("animalName");
		Dog d = new Dog("dogName", "black fur");
		Cat c = new Cat("catName", "blue eye");
		
		System.out.println(a instanceof Animal);
		System.out.println(d instanceof Animal);
		System.out.println(c instanceof Cat);
		System.out.println(a instanceof Cat);
		
		a = new Dog("bigYellow", "yellow fur");  //向上转型
		System.out.println(a.name);
		//System.out.println(a.furColor);
		System.out.println(a instanceof Animal);
		System.out.println(a instanceof Dog);
		
		Dog d1 = (Dog)a; //向下转型
		
		System.out.println(d1.furColor);
	}
}
