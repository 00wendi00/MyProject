/**
 * �ļ�����Mychat.java
 * ��Ŀ-����JAVA���˼�� - �����¸�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-9
 */
package �����¸�����;

import java.util.Random;

/**
 * @author ���ĵ�
 * ������Mychat
 * ��˵���� ��ϰ18.static ǿ�� ��һ�Σ�ֻ��һ��     ����δ�������ʱ��ͬ����final ǿ�� Ϊ���������䡣����static final����   ֻ��һ�ݵ� ������
 *      ��ϰ19.
 */
public class Mychat
{   static int i=0;
	static Random random = new Random(47);
	private static final int VAl_1 = random.nextInt(25);
	private final  int v1 = random.nextInt(20) ;
	private static final Value10 value11 = new Value10(20);
	private final Value10 value12 = new Value10(i);
	private final int k;
     public static void main(String args[])
     { 
    	 Mychat mychat0 = new Mychat();
    	 System.out.println(VAl_1);
    	 System.out.println(mychat0.v1);

    	 
    	 Mychat mychat1 = new Mychat();
    	 System.out.println(VAl_1);
     	 System.out.println(mychat1.v1);
    	 
     	 System.out.println();
    	 
     	// mychat1.i++;
       
    	 mychat1.value11.i++;         
    	 System.out.println(mychat1.value11.i);
    	 System.out.println(mychat1.value11.i++);
    	 System.out.println(mychat1.value11.i);
     }
     public Mychat()
     {
    	 k = 5;
    	 // k++;
     }
}

class Value10
{
    int i;
    public Value10(int i)
    {
    	this.i = i;
    }
}

