/**
 * �ļ�����Storage.java
 * ��Ŀ-����JAVA���˼�� - ��һ����
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-2
 */
package ��һ����;

/**
 * @author ���ĵ�
 * ������Storage
 * ��˵������ϰ6������ֵ
 */
public class Storage
{   
	
	static int storage(String s)
	{
		return s.length()*2;
	}
	
	
	public static void main(String args[])
	{
		String p =new String();
		p="00000000000000";
		System.out.println(storage(p));
	}
}


