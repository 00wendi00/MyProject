/**
 * �ļ�����EnvironmentVariables.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-9
 */
package ��ʮһ��.���ж���;

import java.util.Map;

/**
 * @author ���ĵ�
 * ������EnvironmentVariables
 * ��˵����      ��ʾ���в���ϵͳ�Ļ�������~~~~
 */
public class EnvironmentVariables
{
    public static void main(String args[])
    {
    	for(Map.Entry entry : System.getenv().entrySet())
    	{
    		System.out.println(entry.getKey()+":"+entry.getValue());
    	}
    }
}