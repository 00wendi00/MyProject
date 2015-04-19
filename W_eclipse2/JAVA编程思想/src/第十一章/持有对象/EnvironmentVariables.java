/**
 * 文件名：EnvironmentVariables.java
 * 项目-包：JAVA编程思想 - 第十一章.持有对象
 * 作者：张文迪
 * 创建日期：2014-10-9
 */
package 第十一章.持有对象;

import java.util.Map;

/**
 * @author 张文迪
 * 类名：EnvironmentVariables
 * 类说明：      显示所有操作系统的环境变量~~~~
 */
public class EnvironmentVariables
{
    public static void main(String args[])
    {
    	for(Map.Entry entry : System.getenv().entrySet())
    	{
    		System.out.println(entry.getKey()+":"+entry.getValue());
    	}
    }
}