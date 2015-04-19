/**
 * 文件名：Shine.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第十章
 * 作者：张文迪
 * 创建日期：2014-9-25
 */
package cn.edu.hainu.第十章;


/**
 * @author 张文迪
 * 类名：Shine
 * 类说明：练习 15 ~~~~~~~
 */
class Shine
{
	private int i ;
    Shine(int i)
    {
    	this.i = i;
    }
    public int print1230()
    {
    	return i;
    }
}
public class sunShine
{
	
	public Shine ssssShine(int k)
	{
		return new Shine(k)
		{
			
		};
	}
	public static void main(String args[])
	{
		sunShine sunShine = new sunShine();
		System.out.println(sunShine.ssssShine(999).print1230());
	}
}
