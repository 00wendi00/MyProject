/**
 * 文件名：CreatConstructor.java
 * 项目-包：JAVA编程思想 - 第五章初始化与清理
 * 作者：张文迪
 * 创建日期：2014-9-5
 */
package 第五章初始化与清理;

import javax.swing.JOptionPane;

/**
 * @author 张文迪
 * 类名：CreatConstructor
 * 类说明：练习 3,4,5,6,7. 
 */
public class CreatConstructor
{		
    public static void main(String args[])
    {
    	new Constructor();
    	new Constructor("哈哈");
    	new Constructor(JOptionPane.showInputDialog("请输入"));
    	System.out.println();
    	
    	new Dog();
    	new Dog("~~~~");
    	new Dog("~~~~",222);
    	
    	new Brautiful();
    }
}

class Constructor
{
	Constructor()
	{
		System.out.println("创建了 ！");
	}
    Constructor(String s)
    {
    	System.out.println(s);
    }
}

class Dog
{
	Dog()
	{
		System.out.println("创建了一条狗");
	}
	Dog(String a)
	{
		System.out.println("创建了一条狗");
		System.out.println("barking"+a);
	}
	Dog(String a,int b)
	{
		System.out.println("创建了一条狗");
		System.out.println("barking"+a+" "+"howling"+b);
	}
}


class Brautiful
{
	
}
