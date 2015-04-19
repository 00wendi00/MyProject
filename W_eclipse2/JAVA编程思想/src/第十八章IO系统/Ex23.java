/**
 * �ļ�����Ex23.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-2
 */
package ��ʮ����IOϵͳ;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.BitSet;

/**
 * @author ���ĵ�
 * ������Ex23
 * ��˵����     CharBuffer~~~~~~~~����~~~~~~   ����ʵ�� CharSequence �ӿڣ��Ա��ַ����������������κν����ַ����еĵط�  
 */
public class Ex23 
{
	static BitSet isPrintable = new BitSet(127);   //����ʵ����һ������������λ����
	static String encoding = System.getProperty("file.encoding");   //��ȡָ����ָʾ��ϵͳ����
	static 
	{
		// Assume an encoding that obeys ASCII eg.ISO-8859-1.
		// Characters 32 to 127 represent printable characters.
		for(int i = 32; i <= 127; i++)
			isPrintable.set(i);
	}
	// Set the position to the last printable character
	public static void setPrintableLimit(CharBuffer cb) 
	{
		cb.rewind();//���ƴ˻���������λ������Ϊ 0 ��������ǡ� 
				   //��һϵ��ͨ��д����ȡ ����֮ǰ���ô˷������ٶ��Ѿ��ʵ����������ƣ���
		while(isPrintable.get(cb.get()));
		cb.limit(cb.position() - 1);
		cb.rewind();
	}
	public static void main(String[] args) 
	{
		System.out.println("Default Encoding is: " + encoding);
		CharBuffer buffer = ByteBuffer.allocate(16).asCharBuffer();
		buffer.put("ABCDE" + (char) 0x01 + "FG");
		buffer.rewind();
		System.out.println(buffer); // Print everything
		setPrintableLimit(buffer);
		System.out.println(buffer); // Print printable
	}
}