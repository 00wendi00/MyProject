/**
 * �ļ�����Ex16.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author ���ĵ�
 * ������Ex16
 * ��˵����
 */
public class Ex16
{
	static String file = "C:/Users/���ĵ�/Desktop/�½��ļ���1/2.txt";
	static void display() throws IOException
	{
		RandomAccessFile rf = new RandomAccessFile(file, "r");
		System.out.println(rf.readByte());    
		System.out.println(rf.readShort());
		System.out.println(rf.readChar());
		System.out.println(rf.readInt());
		System.out.println(rf.readLong());
		System.out.println(rf.readFloat());
		System.out.println(rf.readDouble());
		System.out.println(rf.readBoolean());
		System.out.println(rf.readUTF());
		rf.close();
	}
	public static void main(String args[]) throws IOException
	{
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		rf.writeByte('-');
		rf.writeShort(21);
		rf.writeChar('w');
		rf.writeInt(3);
		rf.writeLong(1231);
		rf.writeFloat(213f);
		rf.writeDouble(25152d);
		rf.writeBoolean(true);
		rf.writeUTF("����");
		rf.close();
		display();
		System.out.println("~~~~~~~~~~~");
		
		rf = new RandomAccessFile(file, "rw");    //�� �� �������~ 
		rf.seek(3); // 1 boolean + 2 bytes
		rf.writeChar('B');
		rf.close();
		display();
	}
}
