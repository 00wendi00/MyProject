/**
 * �ļ�����BinaryFile.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-2
 */
package ��ʮ����IOϵͳ;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ���ĵ�
 * ������BinaryFile
 * ��˵������(Byte)���ǳ��ȵ�λ��λ��bit)Ҳ�ǳ��ȵ�λ��
		��Ϊ�����ͨ�źʹ洢��ʱ������010101�����Ķ���������Ϊ�����ģ������һ��0��1ռ�ĵط��ͽ�bit(λ),��һ��������λ��
		1Byte=8bit
		1KB=1024B
 * 
 */
public class BinaryFile
{
	public static byte[] read(File bfile) throws IOException
	{
		BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bfile));
		try
		{
			byte[] data = new byte[bf.available()];//���ؿ��ԴӴ���������ȡ�������������Ҳ��ܴ��������������ķ������������Ĺ����ֽ���
			bf.read(data); //�Ӵ��������н� byte.length ���ֽڵ����ݶ���һ�� byte ������
			return data;  // �� ���뵽data ����~~
		}
		finally
		{
			bf.close();
		}
	}
	public static byte[] read(String bFile) throws IOException
	{
		return read(new File(bFile).getAbsoluteFile());
	}
}
