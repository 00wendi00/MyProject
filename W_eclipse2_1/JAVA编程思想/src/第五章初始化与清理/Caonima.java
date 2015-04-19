/**
 * 文件名：Caonima.java
 * 项目-包：JAVA编程思想 - 第五章初始化与清理
 * 作者：张文迪
 * 创建日期：2014-9-5
 */
package 第五章初始化与清理;

import java.util.Stack;

/**
 * @author 张文迪
 * 类名：Caonima
 * 类说明：练习1,2.两种初始化的 区别
 */
class Haha 
{
	int i = 2; //类初始化
	int j;
	void String()
	{
		j = 3;
	}
}
	
public class Caonima
{
		public static void main(String[] args) 
	{
		Haha b=new Haha();
		System.out.println("类初始化i="+b.i);
		System.out.println("构造器初始化j="+b.j);
	}

}
