/**
 * �ļ�����Cartoon.java
 * ��Ŀ-����JAVA���˼�� - �����¸�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-8
 */
package �����¸�����;

/**
 * @author ���ĵ�
 * ������Cartoon
 * ��˵������ϰ3,4.   �����๹����   ��1.�ܻᱻ���ã�2.�� �����๹���� ֮ǰ������
 */
public class Cartoon extends Drawing
{
     public static void main(String args[])
     {  	 
    	 Cartoon cartoon = new Cartoon();  	 
 	     System.out.println();
    	 Drawing drawing = new Drawing();
     }

	public Cartoon()
	{
		System.out.println("Cartoon construcor");
	}
}
class Drawing extends Art
{
    Drawing()
    {
    	System.out.println("Drawing constructor");
    	
    }
       
}
class Art
{
	Art()
	{
		System.out.println("Art constructor");
	}

}