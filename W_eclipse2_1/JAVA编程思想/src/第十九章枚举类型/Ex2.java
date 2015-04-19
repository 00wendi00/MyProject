/**
 * 文件名：Ex2.java
 * 项目-包：JAVA编程思想 - 第十九章枚举类型
 * 作者：张文迪
 * 创建日期：2014-11-3
 */
package 第十九章枚举类型;

import java.util.Random;

/**
 * @author 张文迪
 * 类名：Ex2
 * 类说明：static next()方法取代Generater接口
 */
enum CartoonCharacter
{
	SLAPPY,HAHA,HAODELA,NIMKJ,ADSSDA;
	static Random random = new Random(47);
	static CartoonCharacter next()
	{
		return values()[random.nextInt(values().length)];
	}
}
public class Ex2
{
	public static void main(String args[])
	{
		for(int i=0;i<8;i++)
		{			
			System.out.println(CartoonCharacter.next());
		}
	}
}
