/**
 * �ļ�����Ex15.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ���ĵ�
 * ������Ex15
 * ��˵����
 */
public class Ex15
{
	public static void main(String args[]) throws IOException
	{
		DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("C:/Users/���ĵ�/Desktop/�½��ļ���1/2.txt")));													
		out.writeByte('-');
		out.writeShort(21);
		out.writeChar('w');
		out.writeInt(3);
		out.writeLong(1231);
		out.writeFloat(213f);
		out.writeDouble(25152d);
		out.writeBoolean(true);
		out.writeUTF("����");
		out.close();
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(new FileInputStream("C:/Users/���ĵ�/Desktop/�½��ļ���1/2.txt")));
		
		//System.out.println(in.read());
		
		System.out.println(in.readByte());    //    - ��ռ���ٸ��ֽ�~~
		System.out.println(in.readShort());
		System.out.println(in.readChar());
		System.out.println(in.readInt());
		System.out.println(in.readLong());
		System.out.println(in.readFloat());
		System.out.println(in.readDouble());
		System.out.println(in.readBoolean());
		System.out.println(in.readUTF());
	}
}
