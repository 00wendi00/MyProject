/**
 * �ļ�����FormattedMemoryInput.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-1
 */
package ��ʮ����IOϵͳ;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author ���ĵ�
 * ������FormattedMemoryInput
 * ��˵����
 */
public class FormattedMemoryInput
{
	public static void main(String args[]) throws IOException
	{
		try
		{
			//��������������Ӧ�ó�����������޹ط�ʽ�ӵײ��������ж�ȡ���� Java �������͡�Ӧ�ó������ʹ�����������д���Ժ���������������ȡ�����ݡ� 		
			DataInputStream in  = new DataInputStream(
					new ByteArrayInputStream(
							BufferedInputFile.read("C:/Users/���ĵ�/Desktop/�½��ļ���1/1.java").getBytes()));
			  //ByteArrayInputStream(byte[] buf)
		     //����һ�� ByteArrayInputStream��ʹ�� buf ��Ϊ�仺�������顣�û��������鲻�Ǹ��Ƶõ��ġ�
		    //pos �ĳ�ʼֵ�� 0��count �ĳ�ʼֵ�� buf �ĳ��ȡ�
			
			while(true)
				System.out.print((char)in.readByte());
		}                                 //�����������������ж�ȡ�˲�����Ҫ���ֽڡ�  ����byte~~
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}
