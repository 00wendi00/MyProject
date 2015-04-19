/**
 * 文件名：Dog.java
 * 项目-包：JAVA编程思想 - 第三章
 * 作者：张文迪
 * 创建日期：2014-9-3
 */
package 第三章;

import java.util.jar.Attributes.Name;

/**
 * @author 张文迪
 * 类名：Dog
 * 类说明：练习5,6
 */
public class Dog
{
    String name;
	
    String says;
	
    
    public static void main(String args[])
    {
    	Dog dog1 = new Dog();
    	Dog dog2 = new Dog();
    	dog1.name = "spot";
    	dog1.says = "ruff";
        dog2.name = "scruffy" ;   	
    	dog2.says = "wurf";
    	System.out.println(dog1.name+" 叫声 "+dog1.says);
    	System.out.println(dog2.name+" 叫声 "+dog2.says);
    	
    	
    	Dog spot = new Dog();
    	spot = dog1;
    	System.out.println(spot==dog1);
    	System.out.println(spot.equals(dog1));
    	
    }
}
