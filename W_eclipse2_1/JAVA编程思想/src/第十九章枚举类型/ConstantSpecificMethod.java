/**
 * 文件名：ConstantSpecificMethod.java
 * 项目-包：JAVA编程思想 - 第十九章枚举类型
 * 作者：张文迪
 * 创建日期：2014-11-3
 */
package 第十九章枚举类型;

import java.util.*;
import java.text.*;
/**
 * @author 张文迪
 * 类名：ConstantSpecificMethod
 * 类说明：
 */
public enum ConstantSpecificMethod
{
	DATE_TIME{
		String getInfo(){
			return 
				DateFormat.getDateInstance().format(new Date());
		}
	},
	CLASSPATH{
		String getInfo(){
			return System.getenv("CLASSPATH");   //获取指定的环境变量值。环境变量是一个取决于系统的外部指定的值。
		}
	},
	VERSION{
		String getInfo(){
			return System.getProperty("java.version");  //获取指定键指示的系统属性
		}
	};
	abstract String getInfo();
	public static void main(String args[])
	{
		for(ConstantSpecificMethod csm: values())
			System.out.println(csm.getInfo());
	}
}
