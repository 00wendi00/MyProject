/**
 *文件名:Internationalization2.java
 *项目-包:数据结构与算法分析,Project1
 *作者:张文迪
 *时间:2015年4月16日
 */
package Project1;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author 张文迪
 * 类名:Internationalization2
 * 类说明:
 */
public class Internationalization2 {
	public static void main(String args[]){
		Locale myLocale = Locale.getDefault();
		ResourceBundle bundle = ResourceBundle.getBundle("mess",myLocale);
		System.out.println(bundle.getString("hello"));
	}
}
