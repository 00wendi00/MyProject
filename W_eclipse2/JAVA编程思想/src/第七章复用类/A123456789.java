/**
 * �ļ�����A123465798.java
 * ��Ŀ-����JAVA���˼�� - �����¸�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-8
 */
package �����¸�����;

/**
 * @author ���ĵ�
 * ������A123465798
 * ��˵������ϰ5
 */
public class A123456789
{
    public static void main(String args[])
    {
    	new C123456789();
    	new B123456879('k');
    	new A123456789('0');
    }
    A123456789(char i)
    {
    	System.out.println("A123456789"+"  "+i);
    }
} 

class B123456879
{
   	B123456879(char i)
   	{
   		System.out.println("B123456789"+"  "+i);
   	}
}

class C123456789 extends A123456789
{
	B123456879 b123456879;
	
	C123456789()
	{
		super('f');		
	}	    
}