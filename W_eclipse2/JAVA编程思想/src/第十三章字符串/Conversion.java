/**
 * �ļ�����Conversion.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����ַ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-14
 */
package ��ʮ�����ַ���;

import java.util.Formatter;

/**
 * @author ���ĵ�
 * ������Conversion
 * ��˵������ϰ5 ~~~����ת��~
 */
public class Conversion
{
	public static void main(String args[])
	{
		Formatter f = new Formatter(System.out);
		int v = 121;
		System.out.println("v = 121");
		f.format("d: %d\n", v);
		f.format("c: %c\n", v);
		f.format("b: %b\n", v);
		f.format("s: %s\n", v);
		f.format("x: %x\n", v);
		f.format("h: %h\n", v);
		
	}
}
