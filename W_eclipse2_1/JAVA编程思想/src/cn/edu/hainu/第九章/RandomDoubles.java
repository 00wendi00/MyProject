/**
 * �ļ�����RandomDoubles.java
 * ��Ŀ-����JAVA���˼�� - cn.edu.hainu.�ھ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-24
 */
package cn.edu.hainu.�ھ���;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ���ĵ�
 * ������RandomDoubles
 * ��˵���� append��ָ���ַ���ӵ��˻�����
 */
public class RandomDoubles
{
    private static Random rand = new Random(47);
    public double next()
    {
    	return rand.nextDouble();
    }
    public static void main(String args[])
    {
    	RandomDoubles rd = new RandomDoubles();
    	for(int i = 0; i<10;i++)
    		System.out.println(rd.next());
    	System.out.println();
    	
    	
    	float[] all = new float[10];//����10�������������
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            double d = random.nextDouble() * 10000 * 1000;//��֤��0-10000��Χ��
            float x = ((int) d) / 1000f;//Ϊ��ȥ��3λС�������ֵ,�����ȷŴ�1000����С1000
            all[i] = x;//��������
            System.out.println(x + "\t ƽ������" + Math.sqrt(x));//��ʾ����õ�����ʾƽ����
        }
        Arrays.sort(all);//��������������
        System.out.println("��Сֵ��" + all[0]);//��ʾ��Сֵ
        System.out.println("���ֵ��" + all[9]);//��ʾ���ֵ
    }
}
