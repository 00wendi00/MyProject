/**
 * �ļ�����UsingRandomAccessFile.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author ���ĵ�
 * ������UsingRandomAccessFile
 * ��˵����"r" ��ֻ����ʽ�򿪡����ý��������κ� write �������������׳� IOException��  
 *		"rw" ���Ա��ȡ��д�롣������ļ��в����ڣ����Դ������ļ���  
 *		"rws" ���Ա��ȡ��д�룬���� "rw"����Ҫ����ļ������ݻ�Ԫ���ݵ�ÿ�����¶�ͬ��д�뵽�ײ�洢�豸��     ~~
 *		"rwd"   ���Ա��ȡ��д�룬���� "rw"����Ҫ����ļ����ݵ�ÿ�����¶�ͬ��д�뵽�ײ�洢�豸��  
 *
 *  	seek(index)���Եģ�  skip(index)����Ե�~~
 */
public class UsingRandomAccessFile
{
	static String file = "C:/Users/���ĵ�/Desktop/�½��ļ���1/2.txt";
	static void display() throws IOException
	{
		RandomAccessFile rf = new RandomAccessFile(file, "r");
		for(int i =0;i<7;i++)
			System.out.println(i+" : "+rf.readDouble());
		System.out.println(rf.readUTF());
		rf.close();
	}
	public static void main(String args[]) throws IOException
	{
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		for(int i = 0;i<7;i++)
			rf.writeDouble(i*1.414);
		rf.writeUTF("end  88!");
		rf.close();
		display();
		
		rf = new RandomAccessFile(file, "rw");
		rf.seek(5*8);      //5*8��ʾ    ��5 ����, 8�ֽڳ���double ��.
		rf.writeDouble(47.0001);
		rf.writeDouble(47.00012); // !!!!
		rf.close();
		display();
	}
}
