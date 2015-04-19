/**
 * 文件名：HiddenB.java
 * 项目-包：测试 - 测试包
 * 作者：张文迪
 * 创建日期：2014-10-20
 */
package 测试包;

/**
 * @author 张文迪
 * 类名：HiddenB
 * 类说明：第14 章：练习25，接口与类型信息 //final修饰的域不能改写~~
 */
public class HiddenMyclass
{
	public static A makeA()
	{
		return new Myclass();
	}
}
