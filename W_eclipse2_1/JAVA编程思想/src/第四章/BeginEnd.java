/**
 * �ļ�����BeginEnd.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-4
 */
package ������;

/**
 * @author ���ĵ�
 * ������BeginEnd
 * ��˵��:  ��ϰ 6.   return
 */
public class BeginEnd
{
	static int test(int testval,int begin,int end)
	{
		if(begin<testval&&testval<end)
			return +1;
		else if (begin>testval||testval>end) 
		{
			return -1;
		}
		else 
		{
			return 0;
		}
	}
	
    public static void main(String args[])
    {
    	System.out.println(test(10,  3, 2));
    	System.out.println(test(6,  5, 9));
    	System.out.println(test(2,  2, 20));
    }
}
