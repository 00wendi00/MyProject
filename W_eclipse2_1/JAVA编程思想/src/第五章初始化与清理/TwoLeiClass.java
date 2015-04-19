/**
 * 文件名：TwoLeiClass.java
 * 项目-包：JAVA编程思想 - 第五章初始化与清理
 * 作者：张文迪
 * 创建日期：2014-9-5
 */
package 第五章初始化与清理;
/**
 * @author 张文迪
 * 类名：TwoLeiClass
 * 类说明：练习8 。 this 关键字。
 */
public class TwoLeiClass
{
    public static void main(String args[])
    {
    	new Pen();
    	
    	new Person().ear(new Apple());
    }
}

class Pen
{
	Pen()
	{
		pen1(this)		
		pen1(null);
	}
	private void pen1(Pen pen)
	{
		System.out.println("调用了");
	}	
}


class Person
{
	public void ear(Apple apple)
	{
		Apple peeled = apple.getPeeled();
		System.out.println("Yummy");
	}
}
class Peeler
{
	static Apple peel(Apple apple)
	{
		return apple;
	}
}
class Apple
{
	Apple getPeeled()
	{
		return Peeler.peel(this);
	}
}