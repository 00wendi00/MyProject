/**
 * �ļ�����Dog.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-3
 */
package ������;

import java.util.jar.Attributes.Name;

/**
 * @author ���ĵ�
 * ������Dog
 * ��˵������ϰ5,6
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
    	System.out.println(dog1.name+" ���� "+dog1.says);
    	System.out.println(dog2.name+" ���� "+dog2.says);
    	
    	
    	Dog spot = new Dog();
    	spot = dog1;
    	System.out.println(spot==dog1);
    	System.out.println(spot.equals(dog1));
    	
    }
}
