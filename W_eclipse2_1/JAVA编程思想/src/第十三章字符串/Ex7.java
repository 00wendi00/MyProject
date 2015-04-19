/**
 * 文件名：Ex7.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-14
 */
package 第十三章字符串;

/**
 * @author 张文迪
 * 类名：Ex7
 * 类说明： 大写字母开头~以句号结尾~   String sen = "^[A-Z].*[\\.]$"; 
 */
public class Ex7
{
	static String s = "Wo nimabi haha.";
	static String k = "~~~~~~~~~~~";
	public static void main(String args[])
	{
		String sen = "^[A-Z].*[\\.]$";  //~~~~~~
		System.out.println(s.matches(sen));
		System.out.println(s.matches(k));
	}
}
