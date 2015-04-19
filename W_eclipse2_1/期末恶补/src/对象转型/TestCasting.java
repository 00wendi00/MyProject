/**
 * �ļ�����TestCasting.java
 * ��Ŀ-������ĩ�� - ����ת��
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-23
 */
package ����ת��;

/**
 * @author ���ĵ�
 * ������TestCasting
 * ��˵����
 */
/**
 * �ļ�����Animal.java
 * ��Ŀ-����oobjectPro - castingPack
 * ���ߣ���ף��
 * �������ڣ�2011-10-23
 */


/**
 * @author ��ף��
 * ������Animal
 * ��˵��������ת��
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
		
		a = new Dog("bigYellow", "yellow fur");  //����ת��
		System.out.println(a.name);
		//System.out.println(a.furColor);
		System.out.println(a instanceof Animal);
		System.out.println(a instanceof Dog);
		
		Dog d1 = (Dog)a; //����ת��
		
		System.out.println(d1.furColor);
	}
}
