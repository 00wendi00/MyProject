/**
 * �ļ�����Exponents.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-3
 */
package ������;

/**
 * @author ���ĵ�
 * ������Exponents
 * ��˵����float��double������

�����ȸ������ڻ���ռ4���ֽڣ���32λ������������ 
˫���ȸ������ڻ���ռ8���ֽڣ���64λ������������ 

�������ڻ�����ָ����ʽ��ʾ���ֽ�Ϊ��������β����ָ������ָ���Ĳ��֡� 
����ռ1λ�����ƣ���ʾ���������� 
ָ����ռ1λ�����ƣ���ʾָ���������� 
β����ʾ��������Ч���֣�0.xxxxxxx,�����濪ͷ��0�͵� 
ָ����ָ������Ч���֡� 

ָ��ռ����λ��β��ռ����λ���ɼ����ϵͳ������ 
������������β��ռ24λ��ָ������ָ��ռ8λ -- float. 
������β��ռ48λ��ָ������ָ��ռ16λ -- double. 

֪�������Ĳ��ֵ�ռλ���������ƹ��ƴ�С��Χ���ٻ���Ϊʮ���ƣ���������֪������ֵ��Χ�� 

�Ա����Ա��˵��double �� float ��������double���ȸߣ���Ч����16λ��float����7λ����double�����ڴ���float��������
double�������ٶȱ�float���ö࣬java��������ѧ��������double �� float��ͬ����Ҫд��
���õ�����ʱ��Ҫ��˫���ȣ���ʡ�ڴ棬�ӿ������ٶȣ�
 */
public class Exponents
{
    public static void main(String args[])
    {
    	float expFloat = 1.39e-43f;
    	expFloat = 1.39e-43f;
    	System.out.println(expFloat);
    	double expDouble = 47e47d;
    	double expDouble2 = 47e47;
    	System.out.println(expDouble);
    	System.out.println(expDouble2);
    	   	
    	float fmax = Float.MAX_VALUE;
    	float fmin = Float.MIN_VALUE;
    	double dmax = Double.MAX_VALUE;
    	double dmin = Double.MIN_VALUE;

    	System.out.println(fmax);
    	System.out.println(fmin);

    	System.out.println(dmax);
    	System.out.println(dmin);
    	
    	
    	
    	
    }
}
