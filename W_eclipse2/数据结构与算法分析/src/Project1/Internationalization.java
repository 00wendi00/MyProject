/**
 *文件名:Internationalization.java
 *项目-包:数据结构与算法分析,Project1
 *作者:张文迪
 *时间:2015年4月16日
 */
package Project1;

import java.util.Locale;

/**
 * @author 张文迪
 * 类名:Internationalization
 * 类说明:  I18N   java国际化 所支持的国家~语言~
 */
public class Internationalization {
	public static void main(String args[]){
		Locale[] locales = Locale.getAvailableLocales();
		for(int i = 0;i<locales.length;i++){
			System.out.println(locales[i].getDisplayCountry()+"="+locales[i].getCountry()+
					" "+locales[i].getDisplayLanguage()+"="+locales[i].getLanguage());
		}
	}
}
