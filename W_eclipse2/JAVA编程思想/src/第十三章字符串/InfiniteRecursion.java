/**
 * �ļ�����InfiniteRecursion.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����ַ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-14
 */
package ��ʮ�����ַ���;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ���ĵ�
 * ������InfiniteRecursion
 * ��˵���� ��ϰ2 ~ ~ 
 */
public class InfiniteRecursion
{
    public String toString()
    {
    	return "InfiniteRecursion address:" + super.toString() + "\n"; // ��this �ͻ�����ʶ�ݹ�~����ѭ��
    }
    public static void main(String args[])
    {
    	List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
    	for(int i = 0;i< 10;i++)
    		v.add(new InfiniteRecursion());
    	System.out.println(v);
    }
}
