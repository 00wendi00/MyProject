/**
 * 文件名：Ex12.java
 * 项目-包：JAVA编程思想 - 第十六章数组
 * 作者：张文迪
 * 创建日期：2014-10-26
 */
package 第十六章数组;

/**
 * @author 张文迪
 * 类名：Ex12
 * 类说明：
 */
import net.mindview.util.*;
import java.util.*;

public class Ex12 
{
	public static void main(String[] args) 
	{
		double[] da = new double[10];
		CountingGenerator.Double dGen = new CountingGenerator.Double();
		for(int i = 0; i < da.length; i++)
			da[i] = dGen.next();
		System.out.println(Arrays.toString(da));	
	}
}
