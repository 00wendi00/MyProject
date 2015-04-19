/**
 * 文件名：ShowMethods17.java
 * 项目-包：JAVA编程思想 - 第十四章类型信息
 * 作者：张文迪
 * 创建日期：2014-10-19
 */
package 第十四章类型信息;

/**
 * @author 张文迪
 * 类名：ShowMethods17
 * 类说明：
 */
import java.lang.reflect.*;
import java.util.regex.*;
import static net.mindview.util.Print.*;

public class ShowMethods17 
{
	private static String usage =
		"usage:\n" +
		"ShowMethods qualified.class.name\n" +
		"To show all methods in class or:\n" +
		"ShowMethods qualified.class.name word\n" +
		"To search for methods involving 'word'";
	private static Pattern p = Pattern.compile("(\\w+\\.)|\\s*final|\\s*native");
	public static void main(String[] args) 
	{
		if(args.length < 1) {
			print(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			if(args.length == 1) 
			{
				for(Method method : methods) 
				{
					print(p.matcher(method.toString()).replaceAll(""));
				}
				for(Constructor ctor : ctors)
					print(p.matcher(ctor.toString()).replaceAll(""));
				lines = methods.length + ctors.length;
			} 
			else 
			{
				for(Method method : methods)
					if(method.toString().indexOf(args[1]) != -1) 
					{
						print(p.matcher(method.toString()).replaceAll(""));
						lines++;
					}
				for(Constructor ctor : ctors) 
					if(ctor.toString().indexOf(args[1]) != -1) 
					{
						print(p.matcher(ctor.toString()).replaceAll(""));
						lines++;
					}
			}
		} catch(ClassNotFoundException e) {
			print("No such class: " + e);
		}
	}
}
