/**
 * �ļ�����CreatConstructor.java
 * ��Ŀ-����JAVA���˼�� - �����³�ʼ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-5
 */
package �����³�ʼ��������;

import javax.swing.JOptionPane;

/**
 * @author ���ĵ�
 * ������CreatConstructor
 * ��˵������ϰ 3,4,5,6,7. 
 */
public class CreatConstructor
{		
    public static void main(String args[])
    {
    	new Constructor();
    	new Constructor("����");
    	new Constructor(JOptionPane.showInputDialog("������"));
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
		System.out.println("������ ��");
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
		System.out.println("������һ����");
	}
	Dog(String a)
	{
		System.out.println("������һ����");
		System.out.println("barking"+a);
	}
	Dog(String a,int b)
	{
		System.out.println("������һ����");
		System.out.println("barking"+a+" "+"howling"+b);
	}
}


class Brautiful
{
	
}
