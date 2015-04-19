/**
 * �ļ�����AdaptedRandomDoubles.java
 * ��Ŀ-����JAVA���˼�� - cn.edu.hainu.�ھ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-24
 */
package cn.edu.hainu.�ھ���;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;


/**
 * @author ���ĵ�
 * ������AdaptedRandomDoubles
 * ��˵����append��ָ���ַ���ӵ��˻�����
 */
public class AdaptedRandomDoubles extends RandomDoubles implements Readable
{
    private int count;
    public AdaptedRandomDoubles(int count)
    {
    	this.count = count ;
    }
    public int read(CharBuffer cb)
    {
    	if(count-- == 0)
    		return -1;
    	String result = Double.toString(next())+" "; 
    	cb.append(result);
    	return result.length();
    }
    public static void main(String args[])
    {
    	Scanner s = new Scanner(new AdaptedRandomDoubles(7));
    	while(s.hasNextDouble())
    		System.out.println(s.nextDouble()+" ");
    }
}
