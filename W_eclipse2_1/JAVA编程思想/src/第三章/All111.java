/**
 * �ļ�����All111.java
 * ��Ŀ-����JAVA���˼�� - ������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-3
 */
package ������;

/**
 * @author ���ĵ�
 * ������All111
 * ��˵������ϰ11,12,13---��λ������
 */
public class All111
{
    public static void main(String args[])
    {
    	
    	int k;
    	k = 0xfedc;
    	System.out.println(k);
    	System.out.println(Integer.toBinaryString(k));
    	k>>=4;
    	System.out.println(Integer.toBinaryString(k));
    	k>>=4;
    	System.out.println(Integer.toBinaryString(k));
    	k>>=4;
    	System.out.println(Integer.toBinaryString(k));
    	k>>=4;
    	System.out.println(Integer.toBinaryString(k));
    	k>>=4;
    	System.out.println(Integer.toBinaryString(k));
    	
    	System.out.println();
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	int i;
        i = 0xffff;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        i<<=2;
        System.out.println(Integer.toBinaryString(i));
        i>>>=4;
        System.out.println(Integer.toBinaryString(i));
        i>>>=4;
        System.out.println(Integer.toBinaryString(i));
        i>>>=4;
        System.out.println(Integer.toBinaryString(i));
        i>>>=4;
        System.out.println(Integer.toBinaryString(i));
        i>>>=4;
        System.out.println(Integer.toBinaryString(i));
        i>>>=4;
        System.out.println(Integer.toBinaryString(i));
        
        System.out.println();
        
        
        
        
        
        
        
        
        
        char c;
        c = 'i';
        System.out.println(Integer.toBinaryString('i'));
        System.out.println(Integer.toBinaryString(c));
        
        c = '\u0049';
        System.out.println(Integer.toBinaryString(c));
       
        c = 'k';
        System.out.println(Integer.toBinaryString(c));
    }
}
