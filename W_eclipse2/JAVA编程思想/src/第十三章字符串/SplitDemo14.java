/**
 * �ļ�����Ex14.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����ַ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-16
 */
package ��ʮ�����ַ���;

import java.util.Arrays;


/**
 * @author ���ĵ�
 * ������Ex14
 * ��˵���� ��ϰ14~~��String.split()------
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
