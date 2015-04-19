/**
 * 文件名：Ex14.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-16
 */
package 第十三章字符串;

import java.util.Arrays;


/**
 * @author 张文迪
 * 类名：Ex14
 * 类说明： 练习14~~用String.split()------
 * 		Pattern.compile("!!").spilt(input,3)~~~~~~~input.split("!!", 3))
 */
public class SplitDemo14 {
	public static void main(String[] args) {
		String input = "This!!unusual use!!of exclamation!!points";
		System.out.println(Arrays.toString(input.split("!!")));
		// Only do the first three:
		System.out.println(Arrays.toString(input.split("!!", 3)));
	}
}
