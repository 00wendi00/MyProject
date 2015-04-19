/**
 * 文件名：Ex2.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-28
 */
package 第十七章深入研究容器;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.mindview.util.Countries;

/**
 * @author 张文迪
 * 类名：Ex2
 * 类说明：先创建List，用sort()~排序，用List.get(index)一个个matches~~
 */
public class Ex201
{
	public static void main(String args[])
	{
		List<String> l = new ArrayList<String>();
		for(int i = 0;i<Countries.DATA.length;i++)
			l.add(Countries.DATA[i][0]);
		System.out.println(l);
		Collections.sort(l);
		System.out.println(l);
		
		for(int i = 0;i<Countries.DATA.length;i++)
		{			
			if(l.get(i).matches("A.*"))	
				System.out.print(l.get(i)+";");
			else 
			{
				break;
			}
		}
	}
}
