/**
 * �ļ�����Switch.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-4
 */
package ������;

/**
 * @author ���ĵ�
 * ������Switch
 * ��˵������ϰ8  �� switch
 */
public class Switch
{
    public static void main(String args[])
    {
    	for(int i=1;i<6;i++)
    	{
    		switch (i)
			{
			case 1:
			case 2:
			case 3:System.out.println("С��4");break;
			case 4:System.out.println("����4");break;
			default:System.out.println("����");
				break;
			}
    	}
    }
}
