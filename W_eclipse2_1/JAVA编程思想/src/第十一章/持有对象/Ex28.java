/**
 * �ļ�����Ex28.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-9
 */
package ��ʮһ��.���ж���;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author ���ĵ�
 * ������Ex28
 * ��˵����
 */
public class Ex28
{
    public static void main(String args[])
    {
    	PriorityQueue<Double> queue = new PriorityQueue<Double>();
    	Random random = new Random(47);
    	for(int i = 0;i<10;i++)  	
    		queue.offer(random.nextDouble()*10);
    	while(queue.peek() != null)
    		System.out.println(queue.poll()+" ");	//remove()  ~~~~~~
    	System.out.println();
    }
}
