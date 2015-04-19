/**
 * 文件名：Ex4.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-28
 */
package 第十七章深入研究容器;

/**
 * @author 张文迪
 * 类名：Ex4
 * 类说明： 如何打开文件，等在  IO流中学习~~
 */
import java.util.*;
import net.mindview.util.*;
import static org.greggordon.tools.Print.*;

public class Ex4 
{
	static Collection<String> CollectFromText(String fileName) 
	{		
		String[] sa = TextFile.read(fileName).split(" ");
		return Arrays.asList(sa);
	}
	static Collection<String> CollectFromText2(String fileName) 
	{		
		String[] sa = TextFile.read(fileName).split(" ");
		return new TreeSet<String>(new TextFile(fileName？？, "\\W+"));
	}
	public static void main(String[] args) 
	{
		println(CollectFromText("Ex4.java"));
		println(CollectFromText2("Ex4.java"));
	}
}