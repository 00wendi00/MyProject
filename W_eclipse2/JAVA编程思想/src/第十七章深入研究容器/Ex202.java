/**
 * 文件名：Ex202.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-28
 */
package 第十七章深入研究容器;

/**
 * @author 张文迪
 * 类名：Ex202
 * 类说明：
 */
import java.util.*;
import java.util.regex.*;
import net.mindview.util.*;


public class Ex202 
{
	public static void main(String[] args) 
	{
		Map<String,String> hm = new HashMap<String,String>();
		Set<String> hs = hm.keySet();   //~~  keySet(),keyValue()~~~
		Pattern p = Pattern.compile("A[a-zA-Z]*");  //"A.*"		
		for(int i = 0; i < Countries.DATA.length; i++) 
		{
			Matcher m = p.matcher(Countries.DATA[i][0]);   // 正则表达式~~中的 m.find();m.group()~
			if(p.matcher(Countries.DATA[i][0]).matches())
				hm.put(Countries.DATA[i][0], Countries.DATA[i][1]);
		}
		System.out.println(hm);	
		System.out.println(hs);	
	}
}
