/**
 * �ļ�����StoringAndRecoveringData.java
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

import javax.imageio.stream.FileImageInputStream;

/**
 * @author ���ĵ�
 * ������StoringAndRecoveringData
 * ��˵����
 */
public class StoringAndRecoveringData
{
	public static void main(String args[]) throws IOException
	{
		DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("C:/Users/���ĵ�/Desktop/�½��ļ���1/1.java")));
		             					//����һ�������ָ�����Ƶ��ļ���д�����ݵ�����ļ���
		out.writeDouble(3.14159);
		out.writeUTF("That was pi");
		out.writeDouble(1.41413);
		out.close();
		
		DataInputStream in  = new DataInputStream(
				new BufferedInputStream(new FileInputStream("C:/Users/���ĵ�/Desktop/�½��ļ���1/1.java")));
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
	}
}
