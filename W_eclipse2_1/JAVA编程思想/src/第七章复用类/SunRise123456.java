/**
 * �ļ�����SunRise123456.java
 * ��Ŀ-����JAVA���˼�� - �����¸�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-8
 */
package �����¸�����;

/**
 * @author ���ĵ�
 * ������SunRise123456
 * ��˵������ϰ13.  ����
 */
public class SunRise123456 extends Sun123456
{
     public static void main(String args[])
     {
    	 SunRise123456 sunRise123456 = new SunRise123456();
    	 sunRise123456.Time123456(2f);
    	 sunRise123456.Time123456(3.0321);
    	 sunRise123456.Time123456('8');
    	 sunRise123456.Time123456(0000,3.0);
     }
     void Time123456(float f)
     {
    	 System.out.println("Time123465(float) = "+f);
     }
     void Time123456(double d)
     {
    	 System.out.println("Time123465(double) = "+d);
     }
     void Time123456(char c)
     {
    	 System.out.println("Time123465(char) = "+c);
     }
     void Time123456(int i,double d)
     {
    	 System.out.println("Time123465(int+double) = "+i+" + "+d);
     }
}

class Sun123456
{
	void Time123456(int i)
	{
		System.out.println("Time123465(int) = "+i);
	}
}
